

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InterThreadCommunication {
	int amount = 10000;

	synchronized void withdraw(int amount) {
		System.out.println("going to withdraw...");

		if (this.amount < amount) {
			System.out.println("Less balance; waiting for deposit...");
			try {
				wait();
			} catch (Exception e) {
			}
		}
		this.amount -= amount;
		System.out.println("withdraw completed...");
	}

	synchronized void deposit(int amount) {
		System.out.println("going to deposit...");
		this.amount += amount;
		System.out.println("deposit completed... ");
		notify();
	}

	public static void main(String[] args) {
		final InterThreadCommunication c=new InterThreadCommunication();  
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.submit(() -> { c.withdraw(15000); });
		
		executor.submit(() -> {c.deposit(15000);});
		
		executor.shutdown();
	}
}
