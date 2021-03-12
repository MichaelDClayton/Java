package logging;

import java.io.IOException;
import java.util.Date;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.RestHighLevelClient;

import client.Integration_ES_Credentials;

public class MyLogger {
	
	private String projectName;
	private String className;
	private RestHighLevelClient client;
	private Integration_ES_Credentials credentials;
	
	public MyLogger(String projectName, String className) {
		this.projectName = projectName;
		this.className = className;
		
		this.credentials = new Integration_ES_Credentials();
		this.client = credentials.getClient();
	}
	
	
	
	public void log(String message, String type) {
		IndexRequest indexRequest = new IndexRequest("logging",type).
				source("Project Name",this.projectName, 
						"Class Name", this.className,
						"Message",message/*,
						"postDate", new Date()*/);
		
		IndexResponse indexResponse = null;
		try{
			indexResponse = client.index(indexRequest);
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		
		indexResponse = null;
		indexRequest = null;
		
		this.credentials.closeConnection();
	}
	
	
}
