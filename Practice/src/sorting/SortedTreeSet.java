package sorting;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedTreeSet {

	public static void main(String[] args) {
		SortedSet<Integer> s = new <Integer>TreeSet<Integer>();
		s.add(1000);
		s.add(12);
		s.add(31);
		s.add(111);
		s.add(123);
		
		//System.out.println(s.toString());
		//System.out.println(s.first());
		
		Iterator<Integer> itr = s.iterator(); 
		while (itr.hasNext()) { System.out.println(itr.next()); }

		
	}
}
