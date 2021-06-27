package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
public static void main(String args[]) {
	List<Integer> myList = new ArrayList<>();
	for(int i=0;i<100;i++) myList.add(i);
	//Sequential Stream
	Stream<Integer> sequentialStream = myList.stream();
	
	//Paralell Stream
	Stream<Integer> parallelStream = myList.parallelStream();
	
	Stream<Integer> highNumSeq = sequentialStream.filter(p -> p>90);
	highNumSeq.forEach(p -> System.out.println("High Nums in Sequential "+p));
	
	Stream<Integer> highNumPara = parallelStream.filter(p->p>90);
	highNumPara.forEach(p->System.out.println("High Num in parallel "+p));
}
}
