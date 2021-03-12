package client;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;

public class ElasticSearchClient {

	private static final String docType = "_doc";

	public static <T> void upsertData(List<T> items, String indexName, String updateIdField) {

		Integration_ES_Credentials credentials = new Integration_ES_Credentials();
		RestHighLevelClient client = credentials.getClient();

		for (Iterator<T> it = items.iterator(); it.hasNext();) {

			HashMap<String, Object> fieldMap = new HashMap<String, Object>();
			Object o = it.next();

			Field[] f = o.getClass().getDeclaredFields();

			for (int i = 0; i < f.length; i++) {

				f[i].setAccessible(true);

				String name = f[i].getName();
				Object value = null;
				try {
					value = f[i].get(o);
				} catch (IllegalArgumentException | IllegalAccessException e) {

					e.printStackTrace();

				}

				fieldMap.put(name, value);
			}


			IndexRequest indexRequest = new IndexRequest(indexName, docType,
			String.valueOf(fieldMap.get(updateIdField))).source(fieldMap);
			UpdateRequest upR = new UpdateRequest(indexName, docType, String.valueOf(fieldMap.get(updateIdField)))
					.doc(indexRequest).upsert(indexRequest);
			UpdateResponse updateResponse = null;
			try {
				updateResponse = client.update(upR, RequestOptions.DEFAULT);
				// System.out.println(updateResponse.getResult());
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}

		}

		try {
			// System.out.println("Attempting to close connection");
			client.close();
		} catch (IOException e) {
			// System.out.println("unable to close connection");
			e.printStackTrace();
		}

		// System.out.println("method end");
		
	}
	
	
	
	public static <T> void insertData(List<T> items, String indexName) {

		Integration_ES_Credentials credentials = new Integration_ES_Credentials();
		RestHighLevelClient client = credentials.getClient();

		for (Iterator<T> it = items.iterator(); it.hasNext();) {

			HashMap<String, Object> fieldMap = new HashMap<String, Object>();
			Object o = it.next();

			Field[] f = o.getClass().getDeclaredFields();

			for (int i = 0; i < f.length; i++) {

				f[i].setAccessible(true);

				String name = f[i].getName();
				Object value = null;
				try {
					value = f[i].get(o);
				} catch (IllegalArgumentException | IllegalAccessException e) {

					e.printStackTrace();

				}

				fieldMap.put(name, value);
			}


			IndexRequest indexRequest = new IndexRequest(indexName, docType).source(fieldMap);
			try {
				IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		try {
			// System.out.println("Attempting to close connection");
			client.close();
		} catch (IOException e) {
			// System.out.println("unable to close connection");
			e.printStackTrace();
		}

		// System.out.println("method end");
		System.exit(0);
	}
}
