package trickyquestion;

public class ConstructorOverloadingNull {
	
	ConstructorOverloadingNull(Object o){
		System.out.println("Object");
	}
	
	ConstructorOverloadingNull(double[] dArray){
		System.out.println("Double Array");
	}
	
	
	/* Creates compiler array, as compiler cant find out which one is the specific one
	 * ConstructorOverloadingNull(String s){
		System.out.println("String");
	}
	*/
	
	public void test(Integer i) {}
	public void test(String i) {}
	
	
	
	public static void main(String args[]) {
		/*
		 * Rule is the which one the effective. As in between Object and Double array, object is the specific one, thus Double array print.s
		 * */
		ConstructorOverloadingNull c = new ConstructorOverloadingNull(null);
		//c.test(null); creates ambious issue as compiler cant find out which one is the more specific.
	}

}
