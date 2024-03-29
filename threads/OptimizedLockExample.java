package multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

public class OptimizedLockExample {
public static void main(String[] args) {
	
	ExecutorService executor = Executors.newFixedThreadPool(2);
	StampedLock lock = new StampedLock();

	executor.submit(() -> {
	    long stamp = lock.tryOptimisticRead();
	    try {
	    	System.out.println(stamp);
	        System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
	        TimeUnit.SECONDS.sleep(1);
	        System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
	        TimeUnit.SECONDS.sleep(2);
	        System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
	    } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	        lock.unlock(stamp);
	    }
	});

	executor.submit(() -> {
	    long stamp = lock.writeLock();
	    try {
	    	System.out.println(stamp);
	        System.out.println("Write Lock acquired");
	        TimeUnit.SECONDS.sleep(2);
	    } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	        lock.unlock(stamp);
	        System.out.println("Write done");
	    }
	});

	executor.shutdown();
}
}
