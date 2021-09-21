package turning;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

public class SortString {
	public static void main(String args[]) {
		List<String> countries = Arrays.asList("Germany","England","China","Denmark","Brazil","France","Australia");
		Optional<String> coutryName = countries.stream().reduce(
				(c1,c2)->c1.length()>c2.length()?c1:c2);
		coutryName.ifPresent(System.out::println);
		
		TreeSet<String> ts=new TreeSet();
		ts.add("3");
		ts.add("1");
		ts.add("2");
		
		System.out.println(ts);
	}

}
