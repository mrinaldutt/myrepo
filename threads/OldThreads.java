package threads;

import java.util.concurrent.TimeUnit;

public class OldThreads {
	public static void main(String args[]) {
		Runnable task = () -> {
			try {
			String threadName = Thread.currentThread().getName();
			System.out.println("Hello "+threadName);
			TimeUnit.SECONDS.sleep(1);
			Thread.sleep(1000);
			System.out.println("Hello "+threadName);
			}catch(InterruptedException e) {
				
			}
		};
		task.run();
		Thread t = new Thread(task);
		t.start();
		System.out.println("Done "+Thread.currentThread().getName());
	}

}
