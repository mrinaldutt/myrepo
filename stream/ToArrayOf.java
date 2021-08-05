package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ToArrayOf {
public static void main(String[] args) {
	List<Integer> l = new ArrayList<Integer>();
	l.add(10);
	l.add(20);
	l.add(4);
	l.add(67);
	l.add(43);
	
	Integer[] array = l.stream().toArray(Integer[]::new);
	for(Integer i : array)
		System.out.println(i);
	
	Stream<Integer> s = Stream.of(999,99,9);
	s.forEach(System.out::println);
	
	Double[] d= {10.0, 20.0, 30.0};
	Stream<Double> sd = Stream.of(d);
	sd.forEach(System.out::println);
}
}
