

package client;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import entity.Person;
/**Makes use of json-simple jar file.
 * Parses the JSON into POJOs.
 * Makes use of Map to capture fields from JSON.
 * We then load the map data into a list of POJOs.
 * 
 * @author mclayton
 * @param SearchResponse reflection.
 * @return List of Person Objects.
 * @since 2017-11-16
 */
public class ResponsePersonHandler {

	
	private List<Person> persons = new ArrayList<Person>();

	public List<Person> handleResponse(SearchResponse response) {

		////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/*
		 * Parse JSON into Person Objects.
		 */
		for (SearchHit hit : response.getHits()) {

			Map<String, Object> map = hit.getSourceAsMap();
			try{
			Person p = new Person(map.get("firstname").toString(), map.get("lastname").toString(),
					map.get("id").toString(), map.get("account_id__c").toString());
			
			this.persons.add(p);
			}catch(NullPointerException ne){
				continue;
			}
		}
		///////////////////////////////////////////////////////////////////////////////////////////////////////////

		return this.persons;
	}

}
