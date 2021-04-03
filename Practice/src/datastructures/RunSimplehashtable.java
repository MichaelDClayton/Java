package datastructures;

import datastructures.Employee;
import datastructures.SimpleHashtable;

public class RunSimplehashtable {

    public static void main(String[] args) {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);
        Employee janeJones2 = new Employee("Jane2", "Jones2", 123);

        SimpleHashtable ht = new SimpleHashtable();
        ht.put("Jones", janeJones);
        ht.put("Jones", janeJones2);
        ht.put("Jones", janeJones2);ht.put("Jones", janeJones2);ht.put("Jones", janeJones2);ht.put("Jones", janeJones2);ht.put("Jones", janeJones2);ht.put("Jones", janeJones2);ht.put("Jones", janeJones2);ht.put("Jones", janeJones2);ht.put("Jones", janeJones2);ht.put("Jones", janeJones2);ht.put("Jones", janeJones2);ht.put("Jones", janeJones2);
        ht.put("Doe", johnDoe);
        ht.put("Wilson", mikeWilson);
        ht.put("Smith", marySmith);

        ht.printHashtable();

        System.out.println("Retrieve key Wilson: " + ht.get("Wilson"));
        System.out.println("Retrieve key Smith: " + ht.get("Smith"));

       // ht.remove("Wilson");
       // ht.remove("Jones");
        ht.printHashtable();

        System.out.println("Retrieve key Smith: " + ht.get("Smith"));



    }

}
