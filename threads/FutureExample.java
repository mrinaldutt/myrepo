package threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureExample {
public static void main(String args[]) throws InterruptedException, ExecutionException, TimeoutException {
	Future<?> future = Executors.newFixedThreadPool(2).submit(
			() -> {
				System.out.println("callable call executing....");				 
				try {
					TimeUnit.SECONDS.sleep(2);
					return 123;
				} catch (InterruptedException e) {
					e.printStackTrace();
					throw new IllegalStateException("Task INterrupted");
				}
				}
			);
	
	System.out.println(future.get(1,TimeUnit.SECONDS));
}}
