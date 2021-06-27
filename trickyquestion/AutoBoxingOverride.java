package trickyquestion;

class A{
	void method(int i) {
		System.out.println("int A");
	}
} 

class B extends A{
	void method(Integer i) {
		System.out.println("Integer B");
	}
}



public class AutoBoxingOverride {
	public static void main(String[] args) {
		A a = new B();
		B b =new B();
		a.method(10);
		a.method(new Integer(10));
		b.method(10);
		b.method(new Integer(10));
		/*
		 * Here method overriding is not possible because the parameter types is mismatch. AUtoboxing feature willnot enabled.
		 * The method call used by the reference variable.
		 * */
	}

}
