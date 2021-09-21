package turning;

import java.util.ArrayList;
import java.util.List;

public  class ExceptionTest {
	
	public static void main(char args[]) {}
	
	
	public static void main(String args[]) {
		
		System.out.println(Math.round(22.9));
		List<String> list1=new ArrayList();
		list1.add("foo");
		
		List<String> list2=list1;
		
		List<String> list3=new ArrayList(list2);
		
		list1.clear();
		
		list2.add("bar");
		list3.add("baz");
		
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(list3);
		
		/*int i;
		System.out.println(i);*/
	}

	//abstract final void test();
}
