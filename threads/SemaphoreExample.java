package multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SemaphoreExample {
public static void main(String[] args) {
	ExecutorService executor =  Executors.newFixedThreadPool(10);
//By using semaphore  you can limit the amount concurrent access to certain parts of your application.	
	Semaphore semaphore = new Semaphore(5);
	
	Runnable longRunningTask = () -> {
		boolean permit = false;
		
		try{
			permit =  semaphore.tryAcquire(1, TimeUnit.SECONDS);
			if (permit) {
	            System.out.println("Semaphore acquired");
	            TimeUnit.SECONDS.sleep(5);
	        } else {
	            System.out.println("Could not acquire semaphore");
	        }
		}catch (InterruptedException e) {
	        throw new IllegalStateException(e);
	    } finally {
	        if (permit) {
	            semaphore.release();
	        }
	    }
	};
	
	IntStream.range(0, 10).forEach(i -> executor.submit(longRunningTask));
	
	executor.shutdown();
	
}
}
