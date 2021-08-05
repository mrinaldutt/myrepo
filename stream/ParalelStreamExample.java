package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ParalelStreamExample {
	public static final int MAX = 1000000;
public static void main(String[] args) {
	List<String> values = new ArrayList<>(MAX);
    for (int i = 0; i < MAX; i++) {
        UUID uuid = UUID.randomUUID();
        values.add(uuid.toString());
    }
    
 // sequential stream
    long t0 = System.nanoTime();
    long count = values.stream().sorted().count();
    System.out.println(count);
    long t1 = System.nanoTime();
    long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
    System.out.println(String.format("sequential sort took: %d ms", millis));
    
 //Paralell
    long t01 = System.nanoTime();
    long count1 = values.parallelStream().sorted().count();
    System.out.println(count1);
    long t11 = System.nanoTime();
    long millis1 = TimeUnit.NANOSECONDS.toMillis(t11 - t01);
    System.out.println(String.format("parallel sort took: %d ms", millis1));
    
    
}
}
