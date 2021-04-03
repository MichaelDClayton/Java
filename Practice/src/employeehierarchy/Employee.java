package employeehierarchy;

import java.util.List;

public class Employee {
	
	protected int id, managerId;
	protected String name;
	protected List<Employee> subordinates;
    
    //Constructor, Time O(1), Space O(1)
    public Employee(String id,  String name, String managerId) {    
	        this.id = Integer.parseInt(id);	        
	        this.name = name;
	        this.managerId = Integer.parseInt(managerId);
    }
}