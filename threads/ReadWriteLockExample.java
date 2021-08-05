package multithread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
public static void main(String[] args) {
	
	ExecutorService executor = Executors.newFixedThreadPool(2);
	Map<String, String> map = new HashMap<>();
	ReadWriteLock lock = new ReentrantReadWriteLock();

	executor.submit(() -> {
	    lock.writeLock().lock();
	    try {
	        Thread.sleep(1000);
	        map.put("foo", "bar");
	        map.put("foo1", "bar1");
	    } catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
	        lock.writeLock().unlock();
	    }
	});
	
	Runnable readTask = () -> {
	    lock.readLock().lock();
	    try {
	        System.out.println(map.get("foo"));
	        System.out.println(map.get("foo1"));
	        Thread.sleep(1000);
	    } catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
	        lock.readLock().unlock();
	    }
	};

	executor.submit(readTask);
	executor.submit(readTask);
	
	executor.shutdown();
	
}
}
