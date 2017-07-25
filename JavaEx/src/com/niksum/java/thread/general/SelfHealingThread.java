package com.niksum.java.thread.general;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SelfHealingThread {
	public static void main(String[] args) {
		exceptionInCallable();
		excrptionInRunnable();
	}
	// Working in Thread excrption in case of Runnable is a bit tricky
	/*
	 * Exception handling in Thread : 
	 * By default run() method doesn’t throw any exception, 
	 * so all checked exceptions inside the run method has to be caught and handled there only and 
	 * for runtime exceptions we can use UncaughtExceptionHandler. UncaughtExceptionHandler is 
	 * an interface provided by Java to handle exceptions in a Thread run method. 
	 * So we can implement this interface and set back our implementing class back to Thread object using setUncaughtExceptionHandler() method. 
	 * But this handler has to be set before we call start() on the tread.
	 * if we don’t set uncaughtExceptionHandler then the Threads ThreadGroup acts as a handler.
	 */
	
	public static void excrptionInRunnable(){
		Runnable task = () -> {
			System.out.println("in Thread");
			throw new RuntimeException("Throwing exception to know");
		};
		Thread myThread = new Thread(task);
		UncaughtExceptionHandler exceHand = new UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
	            System.out.printf("Exception thrown by %s with id : %d",
	                    t.getName(), t.getId());
	            System.out.println("\n"+e.getClass());
	            System.out.println(e.getMessage());
	        }
		};
		myThread.setUncaughtExceptionHandler(exceHand);
		
		
		try{
			myThread.start();
			
		} catch(Exception e){
			System.out.println("Cought exception here");
			myThread.start();
		}
	}
	
	// working in thread exception in case of callable is a easy approach just like below.. in which we 
	// we use the get method of future and will get exception
	
	public static void exceptionInCallable(){
		ExecutorService exeSer = Executors.newFixedThreadPool(1);
		Callable<Void> callObj = () -> {
			System.out.println("In callable's call method");
			Thread.sleep(1000);
			throw new IllegalStateException("I am throwing this exception");
		};
		
		Future<Void> fut = exeSer.submit(callObj);
		
		try {
			fut.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			System.out.println("caught the exception thrown by callable");
			e.printStackTrace();
		} finally {
			exeSer.shutdown();
		}
	}
}
