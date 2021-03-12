package client;
import java.util.List;

import entity.Person;
/**class to run this java client.
 * 
 * @author mclayton
 * @since 2017-11-16
 * 
 */
public class Search {

	
	public static void main(String[] args) {
		
		ESWorker worker = new ESWorker();
		List<Person> persons = worker.searchByNames("John", "Doe");
		System.out.println("Number of Records Returned: "+persons.size());
	}
}
