
package client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;
import org.apache.http.ParseException;
import org.apache.http.message.BasicHeader;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.json.simple.JSONArray;

import entity.Person;
import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * This class handles the fuzzy search. Makes use of ElasticSearch REST client.
 * 
 * 
 * @author mclayton
 * @param firstname
 * @param lastname
 * @since 2017-11-16
 * @returns List<Person>
 */
public class ESWorker {

	

	public List<Person> searchByNames(String firstname, String lastname) {

		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		/*
		 * get REST client
		 */
		Integration_ES_Credentials credentials = new Integration_ES_Credentials();
		RestHighLevelClient client = credentials.getClient();
		/////////////////////////////////////////////////////////////////////////////////////////////////////////

		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		/*
		 * Build the query
		 */
		MatchQueryBuilder matchFirstname = new MatchQueryBuilder("firstname", firstname).fuzziness(Fuzziness.AUTO);
		MatchQueryBuilder matchLastname = new MatchQueryBuilder("lastname", lastname).fuzziness(Fuzziness.AUTO);
		BoolQueryBuilder qb = boolQuery().must(matchFirstname).must(matchLastname);
		SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
		sourceBuilder.query(qb);
		SearchRequest searchRequest = new SearchRequest("cti-data");
		searchRequest.source(sourceBuilder);
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////

		///////////////////////////////////////////////////////////////////////////////////////////////////////////
		/*
		 * Process the response
		 */
		SearchResponse response = null;
		try {
			response = client.search(searchRequest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// System.out.println(response);

		////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/*
		 * 
		 * Handle response, json to reflection(s).
		 */
		ResponsePersonHandler responsePersonHandler = new ResponsePersonHandler();
		List<Person> persons = responsePersonHandler.handleResponse(response);
		////////////////////////////////////////////////////////////////////////////////////////////////////////////

		/*
		 * Close the connection.
		 */
		credentials.closeConnection();

		/*
		 * return data.
		 */
		return persons;

	}

	public static void searchByNamesWithHttpEntity(String firstname, String lastname) {
		String encodedBytes = Base64.getEncoder().encodeToString("elastic:vLdTfYSxspy2y7PoMJKfItxO".getBytes());
		Header[] headers = { new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json"),
				new BasicHeader("Authorization", "Basic " + encodedBytes) };

		RestClient r = RestClient
				.builder(new HttpHost("871ea2cafea452c5c4ab98aa9a4a9b2f.us-east-1.aws.found.io", 9243, "https"))
				.setDefaultHeaders(headers).build();

		/*
		 * Response response = r.performRequest("GET", "/", params);
		 * 
		 * 
		 */

		HttpEntity entity = null;
		try {
			entity = new NStringEntity("{" + "\"query\": {" + " \"bool\": {" + "\"must\": [" + "{" + "\"match\": {"
					+ "\"firstname\": {" + "\"query\": \"" + firstname + "\"," + "\"fuzziness\": \"AUTO\"" + "}" +

					"}" + "}," + "{" + "\"match\": {" + "\"lastname\": {" + "\"query\": \"" + lastname + "\","
					+ "\"fuzziness\": \"AUTO\"" + "}" + "}" + "}" + "]" + "}" + "}" + "}");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Map<String, String> paramMap = new HashMap<String, String>();
		// paramMap.put("q", "firstname:sean");
		paramMap.put("pretty", "true");

		Response response = null;
		try {
			response = r.performRequest("GET", "/*/_search", paramMap, entity);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			System.out.println(EntityUtils.toString(response.getEntity()));
		} catch (ParseException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Host -" + response.getHost());
		System.out.println("RequestLine -" + response.getRequestLine());
		System.out.println(response.toString());

		//////////
		try {
			r.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
