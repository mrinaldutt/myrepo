package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SumExample {
	public static void main(String[] args) {
		Integer arr[] = { 2, 8, 3, 4, 4, 5, 6, 7 };
		List<Integer> numbers = Arrays.asList(arr);
		
		List<Integer> collect = numbers.stream().map(x -> x*x).collect(Collectors.toList());
		System.out.println(collect);
		
		System.out.println(numbers.stream().map(x -> x*x).reduce(0, Integer::sum));
		
		System.out.println(numbers.stream().map(x -> x*x*x).reduce(0, (x,y)->x+y));
		
		System.out.println(numbers.stream().filter(x-> x%2!=0).reduce(0, Integer::sum));
	}
}
