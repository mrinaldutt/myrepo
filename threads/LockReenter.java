package multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class LockReenter {
	ReentrantLock lock = new ReentrantLock();
	int count = 0;

	/*void increment() {
		lock.lock();
		try {
			count++;
		} finally {
			lock.unlock();
		}
	}*/

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.submit(() -> {
		    lock.lock();
		    try {
		        Thread.sleep(1000);
		    } catch (Exception e) {
				e.printStackTrace();
			} finally {
		        lock.unlock();
		    }
		});

		executor.submit(() -> {
			
		    System.out.println("Locked: " + lock.isLocked());
		    System.out.println("Held by me: " + lock.isHeldByCurrentThread());
		  //The method tryLock() as an alternative to lock() tries to acquire the lock without pausing the current thread.
		    boolean locked = lock.tryLock();  
		    System.out.println("Lock acquired: " + locked);
		});
		
		executor.shutdown();
	}
}
