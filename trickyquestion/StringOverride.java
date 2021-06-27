package trickyquestion;

public class StringOverride {
public static void main(String args[]) {
	String s=new String("hello");
	System.out.print(s);	
}
}

/*
 * here we have defined String class. Thus the main method which will execute the progrma will not avaailable
 * */

/*class String{
	java.lang.String s;
	
	public String(java.lang.String s){
		this.s = s;
	}
	
	public java.lang.String toString(){
		return s;
	}
}*/
