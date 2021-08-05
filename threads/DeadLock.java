

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadLock {
	public static void main(String[] args) {
		final String resource1 = "Mrinal Dutta";
		final String resource2 = "Aditri Dutta";
		// t1 tries to lock resource1 then resource2
		ExecutorService executor = Executors.newFixedThreadPool(2);

		executor.submit(() -> {
			synchronized (resource1) {
				System.out.println("Thread 1: locked resource 1");

				try {
					Thread.sleep(100);
				} catch (Exception e) {
				}
				
			synchronized (resource2) {
				System.out.println("Thread 1: locked resource 2");
			}
		}});
		
		executor.submit(() -> {
			synchronized (resource2) {
				System.out.println("Thread 2: locked resource 2");  

				try {
					Thread.sleep(100);
				} catch (Exception e) {
				}

			synchronized (resource1) {
				System.out.println("Thread 2: locked resource 1");  
			}
		}
		});
		
		executor.shutdown();
	}
}
