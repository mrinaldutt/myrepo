package threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduleExecutor {
	
	public static void main(String args[]) {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
		Callable task = () -> {
			System.out.println("Scheduling: "+System.nanoTime());
			return "task1";
			};

		Callable task1 = () -> {
				System.out.println("Scheduling: "+System.nanoTime());
				return "task2";
				};
		
		ScheduledFuture<?> future = executor.schedule(task, 3, TimeUnit.SECONDS);
		ScheduledFuture<?> future1 = executor.schedule(task1, 3, TimeUnit.SECONDS);
		
				
		try {
			TimeUnit.MILLISECONDS.sleep(1337);
			long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
			System.out.printf("Remaining Delay: %sms", remainingDelay);
			System.out.println(future.get());
			System.out.println(future1.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
