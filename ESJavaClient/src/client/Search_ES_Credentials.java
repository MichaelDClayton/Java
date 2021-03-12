
package client;

import java.io.IOException;
import java.util.Base64;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
/**Provides HighLevel and LowLevel Rest Client reflection.
 * The endpoint points to specific cluster endpoint.
 * Within the cluster are multiple indices. we are using the CTI-* index.
 * 
 * 
 * @author mclayton
 * @returns RestHighLevelClient
 * @since 2017-11-16
 */

public class Search_ES_Credentials {

	private final String username = "elastic";
	private final String password = "*************";
	private final String END_POINT = "*******************.us-east-1.aws.found.io"; 
	private RestClient restLowLevelClient;
	private RestHighLevelClient client;

	public RestHighLevelClient getClient(){
		String CREDENTIALS_STRING = this.username+":"+this.password;
		String encodedBytes = Base64.getEncoder().encodeToString(CREDENTIALS_STRING.getBytes());
		Header[] headers = { new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json"),
				new BasicHeader("Authorization", "Basic " + encodedBytes) };
				this.client = new RestHighLevelClient(RestClient.builder(
				        new HttpHost(this.END_POINT, 9243, "https")).setDefaultHeaders(headers));
				return this.client;
		
		
		
	}

	

	

	





	/*public String getINDEX_NAME() {
		return INDEX_NAME;
	}
*/










	public void closeConnection(){
		try {
			this.restLowLevelClient.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
