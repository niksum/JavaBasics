package com.niksum.java.thread.general;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

public class ThreadVsExecutor {
	public static void main(String[] args) {
		Runnable task = () -> System.out.println("Running task on " + Thread.currentThread().getName());
		// in below case you will see for 8 task to run JVM is creating that
		// many number of thread.
		for (int i = 0; i < 8; i++) {
			new Thread(task).start();
		}

		// Let's see the same result in case of using executors
		// in single thread model we will be using same thread to execute all
		// task.
		ExecutorService service = Executors.newSingleThreadExecutor();
//		Executors.newCachedThreadPool();
//		ScheduledExecutorService sc = Executors.newScheduledThreadPool(4);
		for (int i = 0; i < 8; i++) {
			service.submit(task);
		}
		service.shutdown();

		ExecutorService service2 = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 8; i++) {
			service2.submit(task);
		}
		service2.shutdown();

		Callable<String> workerTask = () -> {
			return ("Working on callable call method " + Thread.currentThread().getName());
		};

		ExecutorService service3 = Executors.newFixedThreadPool(3);
		Future<String> fu = null;
		try {
			for (int i = 0; i < 8; i++) {
				fu = service3.submit(workerTask);
				System.out.println("I got result " + fu.get());
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} finally {
			service3.shutdown();
		}
		
		
		Callable<String> throwTask = () -> {
			throw new IllegalStateException("Throwing exception " + Thread.currentThread().getName());
		};
		
		ExecutorService service4 = Executors.newFixedThreadPool(2);
		Future<String> fut = null;
		try {
			for (int i = 0; i < 3; i++) {
				fut = service4.submit(throwTask);
				System.out.println("I got result " + fut.get());
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} finally {
			service4.shutdown();
		}
	}
}
