package hackerrank;

public class Counting_Valley {
	
	

    public static int countingValleys(int steps, String path) {
        // Write your code here
    	char[] charArray = path.toCharArray();
        int baseline = 0;
        int countValley = 0;
        for(int counter = 0; counter < charArray.length; counter ++) {
        	if(charArray[counter] == 'D') {
        		if(baseline == 0)  countValley = countValley+1;    
        		--baseline;
        	}else {
        		++baseline;
        	}   		
        	 
        }
       
        return countValley;
        }
    
    public static void main(String args []) {
    	int result = countingValleys(12, "DDUDDD");
    	System.out.println(result);
    }

}
