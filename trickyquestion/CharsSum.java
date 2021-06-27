package trickyquestion;

public class CharsSum {
public static void main(String args[]) {
	System.out.println("H"+"I");
	System.out.println('H'+'I'); // as soon we pass char it will convert into ascii value and print.
	int x = 'H';
	int y = 'I';
	System.out.println(x+","+y);
	System.out.println('H'); //ascii only convertion if and only if arithmetic opertaion with char.
}
}
