package trickyquestion;

import java.util.Random;

public class StringBufferWithChar {
	
	private static Random rnd = new Random();
	public static void main(String args[]) {
	
		StringBuffer word = null;
		switch(rnd.nextInt(5)){
		case 1: 
			word = new StringBuffer('B');
		case 2:
			word = new StringBuffer('C');
		case 3:
			word = new StringBuffer('M');
		}
		
		System.out.println(word.capacity());
		word.append('A');
		word.append('I');
		word.append('N');
		
		System.out.println(word);
		/*
		 * Its always print AIN as all of the swtich condition statement first no break, thus last case (case 3) will always executed.
		 * Also, in case3, only initialize word with empty string buffer, no parameter. No definition. The parameter only takes as an int as a cpaacity
		 * If we change all of the char to string, then Return value will be different.
		 * */
	}
	
}
