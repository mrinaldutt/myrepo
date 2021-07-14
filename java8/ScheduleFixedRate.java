package threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleFixedRate {
	public static void main(String args[]) {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		
		Runnable task = () ->{
			System.out.println("scheduling "+ System.nanoTime());
		};
		
		int initialDelay = 0;
		int period = 1;
		executor.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);
		
		executor.scheduleWithFixedDelay(task, 0, 1, TimeUnit.SECONDS);
	}

}
