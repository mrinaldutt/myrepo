package hackerrank;

public class AdditionRecurrsion {
	
	private static int kTime(int i, int j) {
		System.out.println(i);
		if(i>1) {
			return j+kTime(i-1, j);
		}else {
			return j;
		}
	}
	
	 public static int factorial(int n) {
		    if(n>1) {
		    	return n*factorial(n-1);
		    }else {
		    	return n;
		    }

		    }
	 
	 
public static void main(String args[]) {
	//int result = kTime(4,4);
	//System.out.println(result);
	
	int fac = factorial(4);
	System.out.println(fac);
}
}
