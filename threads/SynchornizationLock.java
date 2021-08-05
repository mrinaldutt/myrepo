package multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchornizationLock {
	
	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		executor.submit( () -> {
			printTable(5);
		});
		
		executor.submit( () -> {
			printTable(100);
		});
		
		executor.shutdown();
	}
	
	  static synchronized void printTable(int n){//method not synchronized  
		   for(int i=1;i<=5;i++){  
		     System.out.println(n*i);  
		     try{  
		      Thread.sleep(400);  
		     }catch(Exception e){System.out.println(e);}  
		   }  
		   
		 }  
}
