package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CountSortedExample {
public static void main(String[] args) {
	List<String> l = new ArrayList<String>();
	l.add("Mrinal");
	l.add("Aditri");
	l.add("Nil");
	l.add("Sreemoyee");
	l.add("Debabrata");
	
	long count = l.stream().filter(s -> s.length()>4).count();
	System.out.println(count);
	
	List<String> collect = l.stream().sorted().collect(Collectors.toList());
	System.out.println(collect);
	
	List<String> collect4 = l.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
	System.out.println(collect4);
	
	List<String> collect2 = l.stream().sorted((i1,i2) -> i2.compareTo(i1)).collect(Collectors.toList());
	System.out.println(collect2);
	
	List<String> collect3 = l.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
	System.out.println(collect3);
	
	List<String> collect5 = l.stream().sorted(Comparator.comparing(s -> s.length(), (i1,i2) -> i2.compareTo(i1))).collect(Collectors.toList());
	List<String> collect6 = l.stream().sorted(Comparator.comparing(s -> s.length())).collect(Collectors.toList());
	System.out.println(collect5);
	System.out.println(collect6);
	
	
	
}
}
