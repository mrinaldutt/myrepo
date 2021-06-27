package threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableTask {
	
	public static void main(String args[]) {
		Callable<Integer> task = () -> {
			try {
				TimeUnit.SECONDS.sleep(1);
				System.out.println("Callable Statement call exeuting..");
				return 123;
			}catch(InterruptedException e) {
				throw new IllegalStateException("Task Interrupted", e);
			}
		};
		
		ExecutorService executor =  Executors.newFixedThreadPool(1);
		try {
		Future<?> future = executor.submit(task);
		System.out.println("Future Done? "+future.isDone());
		//executor.shutdownNow();  //It will throw an exception as future still not retuning the result. 
		System.out.println(future.get());
		System.out.println("Future Done? "+future.isDone());
		
		}catch(InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}finally {
			executor.shutdownNow();
			System.out.println("shutdown finished");
		}
	}

}




