package multithread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

public class StampedLockExample {
public static void main(String[] args) {
	ExecutorService executor = Executors.newFixedThreadPool(2);
	Map<String, String> map = new HashMap<>();
//StampedLock which also support read and write locks just like in the example above. 
//In contrast to ReadWriteLock the locking methods of a StampedLock return a stamp represented by a long value. 	
	StampedLock lock = new StampedLock();

	executor.submit(() -> {
	    long stamp = lock.writeLock();
	    try {
	        TimeUnit.SECONDS.sleep(1);
	        map.put("foo", "bar");
	    } catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
	        lock.unlockWrite(stamp); //unlock using stamp
	    }
	});

	Runnable readTask = () -> {
	    long stamp = lock.readLock();
	    try {
	        System.out.println(map.get("foo"));
	        TimeUnit.SECONDS.sleep(1);
	    } catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
	        lock.unlockRead(stamp); //unlock using stamp
	    }
	};

	executor.submit(readTask);
	executor.submit(readTask);

	executor.shutdown();
}
}
