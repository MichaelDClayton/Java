package arraysandstrings;
public class Palindrome {
	public static void main(String[] args) {
		Palindrome p = new Palindrome();
		boolean res = p.isPalindrome("race car");
		System.out.println("Result: "+res);
	}	
	public boolean isPalindrome(String s) {
		
		String cleaned_string = "";
		for(char c : s.toCharArray()) {
			if(Character.isLetter(c) || Character.isDigit(c)) {
				cleaned_string += c;
			}
		}	
			cleaned_string = cleaned_string.toLowerCase();
			System.out.println("Cleaned String: "+cleaned_string);
			int left_pointer = 0;
			int right_pointer = cleaned_string.length()-1;
			
			while(left_pointer <= right_pointer) {
				if(cleaned_string.charAt(left_pointer) != cleaned_string.charAt(right_pointer)) {
					return false;
				}
			
				left_pointer+=1;
				right_pointer-=1;
			}		
		return true;
			
	}
}
