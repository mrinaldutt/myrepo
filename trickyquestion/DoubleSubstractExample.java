package trickyquestion;

import java.math.BigDecimal;

public class DoubleSubstractExample {
public static void main(String args[]) {
	double d = 1.10 - 1.00;
	System.out.println(d);
	if(d==0.10) {
		System.out.println("Hello");
	}else {
		System.out.println("Hi");
	}
	
	BigDecimal d1 = new BigDecimal("1.10").subtract(new BigDecimal("1.0"));;
	System.out.println(d1);
	if(d1.doubleValue()==0.10) {
		System.out.println("Hello");
	}else {
		System.out.println("Hi");
	}
}
}
