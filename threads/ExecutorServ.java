package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServ {
	public static void main(String args[]) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(()->{
			System.out.println("hello "+Thread.currentThread().getName());
		}); 
		
		try {
			System.out.println("Attempt to shutdown  executor");
			executor.awaitTermination(5, TimeUnit.SECONDS);
			executor.shutdown();
			TimeUnit.SECONDS.sleep(5);
		}catch(InterruptedException e) {
			System.out.println("tasks interrupt4ed "+e);
		}finally {
			if(!executor.isTerminated()) {
				System.err.println("Cancel non-finished tasks");
			}
			executor.shutdownNow();
			System.out.println("shutdown finished");
		}
		
		
	}

}
