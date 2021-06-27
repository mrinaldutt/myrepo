package java8;

public class DefaultStatic implements Interface1, Interface2{

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method1(String str) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void log(String str) {
		// TODO Auto-generated method stub
		System.out.println("DefaultStatic class");
		Interface1.print(str);
	}

	public static void main(String args[]) {
		new DefaultStatic().log("Hello");
		
		Runnable r = new Runnable() {
			public void run() {
				System.out.println("Runnable implementation");
			}
		};
		
		Runnable r1 = () -> System.out.println("My Lambda Runable");
		new Thread(r).start();
		new Thread(r1).start();
		Interface1 i1 = s-> System.out.println(s);
		i1.method1("Mrinal");
	}

}
