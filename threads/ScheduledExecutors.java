import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutors {
public static void main(String[] args) throws InterruptedException {
	
//ScheduledExecutorService is capable of 
//scheduling tasks to run either periodically or once after a certain amount of time has elapsed.	
	ScheduledExecutorService  executor = Executors.newScheduledThreadPool(1);
	Runnable task = () -> {
		try {
			TimeUnit.SECONDS.sleep(2);
			System.out.println("Scheduling: " + System.nanoTime());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	};
	
	/*ScheduledFuture<?> future = executor.schedule(task, 3, TimeUnit.SECONDS);	
	TimeUnit.MILLISECONDS.sleep(1337);
	long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
	System.out.printf("Remaining Delay: %sms", remainingDelay);*/
	
	//In order to schedule tasks to be executed periodically, executors provide the two methods 
	//scheduleAtFixedRate() and scheduleWithFixedDelay().
	int initialDelay = 0;
	int period = 1;
	//scheduleAtFixedRate() doesn't take into account the actual duration of the task.
	executor.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);
	
	//executor.scheduleWithFixedDelay(task, 0, 1, TimeUnit.SECONDS);
	//The initial delay is zero and the tasks duration is two seconds. 
	//So we end up with an execution interval of 0s, 3s, 6s, 9s and so on
	
	
	
}
}
