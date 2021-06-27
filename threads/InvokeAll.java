package threads;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;

public class InvokeAll {
	public static void main(String argd[]) throws InterruptedException {
		
		ExecutorService executor = Executors.newWorkStealingPool();
		List<Callable<String>> callables = Arrays.asList(
				() -> "task1",
				() -> "task2",
				() -> "task3");
		
		List<Future<String>> futures=executor.invokeAll(callables);
		//this way we can get the values from future.
		futures
		.stream()
		.map(future ->{
					try {
						return future.get();
					} catch (Exception e) {
						throw new IllegalStateException(e);
					}
		}).forEach(System.out::println);;
		
		//another way
		futures.forEach(new Consumer<Future>() {
			@Override
			public void accept(Future t) {
				try {
					System.out.println(t.get());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

}
