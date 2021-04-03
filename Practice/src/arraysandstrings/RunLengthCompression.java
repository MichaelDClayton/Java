/**
 * Run Length Compression
 * 
 * @author mclayton
 * 
 */

package arraysandstrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class RunLengthCompression {

	
	public static void main(String[] args) {
		System.out.println("compress1");
		String compressedString = compress1("aabbbccccf");
		System.out.println(compressedString);
		System.out.println("----------------------------------------");
		char[] chars = {'a','a','a','a','a','a','a','a','a','a','b','c','c','e'};
		System.out.println("compress2");
		int compressedLen = compress2(chars);
		System.out.println("compress2: Length = "+compressedLen);
		
	}
	
	
	
	public static int compress2(char[] chars) {
		//used as the index to the new array chars, it's rebuilt!
		int index = 0;
		//index for each letter to check, as a anchor character.
		int i = 0;
		
		while(i<chars.length) {
			//point variable at i so we start here for checking char[j].
			int j = i;
			while(j<chars.length && chars[j] == chars[i]) {
				j++;
			}
			
			/*
			 * at this point we rebuild the char[]. chars[i] is the letter.
			 */
			chars[index++] = chars[i];
			/*
			 * then we build string from the letter and the number.
			 * we use index as a reference all the way through the process.
			 */
			if(j - i > 1) {
				String count = j - i +"";
				for(char c : count.toCharArray()) {
					chars[index++] = c;
				}
			}
			//set our next begining to j, j is where we left off, so set i =j;
			i = j;
		}
		
		return index;
	}
	
	public static String compress1(String s) {
		/*
		 * "abbccddfff" = a1b2c2d2f3.
		 */
		
		//convert string to char[]
		char[] chars = s.toCharArray();
		
		/*
		 * skip past the first char by setting prev = char[0].
		 * this way we can start by comparing char[1] to char[0] (disguised as prev).
		 */
		int counter = 1;
		char prev = chars[0];
		
		/*
		 * StringBuilder sb to hold the final String object.
		 */
		StringBuilder sb = new StringBuilder();
		
		/*
		 * loop.
		 */
		for(int i=1;i<chars.length;i++) {
			/*
			 * if current char = prev, we increment counter.
			 */
			if(chars[i] == prev) {
				counter++;
			}else {
				/*
				 * if the char is != prev we now we have a new char,
				 * we append the new char to the StringBuilder sb 
				 * and set the count = 1 (kind of like a reset/restart to the count.
				 * we dont set to 0, we set to 1 to account for current, new char.. 
				 */
				sb.append(prev).append(counter);
				prev = chars[i];
				counter = 1;
			}
		}
	/*
	 * we need to append once more to account for the last: char[length-1].
	 */
	sb.append(prev).append(counter);		
	//System.out.println(sb.toString());
	return sb.toString();
	
	}
	
		
		
	
	
}
