package arraysandstrings;

import java.util.HashSet;

public class LongestSubstring {

	public static void main(String[] args) {
		LongestSubstring sub = new LongestSubstring();
		int max = sub.lengthOfLongestSubstring("bbbcfg");
		System.out.println("Max Length: "+max);
	}
	
	
	public int lengthOfLongestSubstring(String s) {
        
       int a_pointer = 0;
       int b_pointer = 0;
       int max = 0;
       
       HashSet<Character> mySet = new HashSet<Character>();
       
       while(b_pointer < s.length()) {
    	   if(!mySet.contains(s.charAt(b_pointer))) {
    		   mySet.add(s.charAt(b_pointer));
    		   b_pointer++;
    		   max = Math.max(max, mySet.size());
    	   }else{
    		   mySet.remove(s.charAt(a_pointer));
    		   a_pointer++;
    	   }
       }
       return max;
    }
}
