package math;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SumNumber {

	
	public static void main(String[] args) {
		int result = 0;
		String str = "AA-10EDF10";      
		str = str.replaceAll("[^-?0-9]+", " "); 
		System.out.println(str);
		List r = Arrays.asList(str.trim().split(" "));
		for(Iterator it = r.iterator();it.hasNext();) {
			result+=Integer.parseInt((String) it.next());
		}
		
		System.out.println("Result: "+result);
	}
	
}
