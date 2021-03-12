
package entity;
/**Entity Object, a Person.
 * 
 * @author mclayton
 */

public class Person {

	public String firstname;
	public String lastname;
	public String id;
	public String account_id__c;
	
	public Person(String firstname, String lastname, String id, String account_id__c) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.id = id;
		this.account_id__c = account_id__c;
	}
	
	
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public String getId() {
		return id;
	}
	public String getaccount_id__c() {
		return account_id__c;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setaccount_id__c(String account_id__c) {
		this.account_id__c = account_id__c;
	}
	
	
	
	
	
}
