package multithread;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class ForkJoinWithStream {
public static void main(String[] args) throws InterruptedException, ExecutionException {
	long firstNum = 1;
    long lastNum = 1_000_000;
    
    List<Long> aList = LongStream.rangeClosed(firstNum, lastNum).boxed().collect(Collectors.toList());
    ForkJoinPool customThreadPool = new ForkJoinPool(4);
    try {
    long actualTotal = customThreadPool.submit(() -> aList.parallelStream().reduce(0L, (a,b) -> a+b)).get();
    long actualTotal1 = customThreadPool.submit(() -> aList.parallelStream().reduce(0L, Long::sum)).get();
    
    System.out.println((lastNum + firstNum) * lastNum / 2 + " " + actualTotal);
    }finally {
        customThreadPool.shutdown();
    }
}
}
