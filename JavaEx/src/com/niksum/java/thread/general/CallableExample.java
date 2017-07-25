package com.niksum.java.thread.general;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class MyCallable implements Callable<String> {

	private long waitTime;

	public MyCallable(long waitTime, String threadName) {
		this.waitTime = waitTime;
		Thread.currentThread().setName(threadName);
	}

	@Override
	public String call() throws Exception {
		Thread.sleep(this.waitTime);
		return Thread.currentThread().getName();
	}

}

public class CallableExample {
	public static void main(String[] args) {
		MyCallable call1 = new MyCallable(1000, "First Call");
		MyCallable call2 = new MyCallable(2000, "Second Call");
		FutureTask<String> fuTas1 = new FutureTask<>(call1);
		FutureTask<String> fuTas2 = new FutureTask<>(call2);

		ExecutorService service = Executors.newFixedThreadPool(2);
		service.execute(fuTas1);
		service.execute(fuTas2);

		while (true) {
			try {
				if (fuTas1.isDone() && fuTas2.isDone()) {
					System.err.println("I am done bye bye");
					service.shutdown();
					return;
				}

				if (!fuTas1.isDone())
					System.out.println("Thread output" + fuTas1.get());
				System.out.println("waiting for second task to complete");
				String s = fuTas2.get(200L, TimeUnit.MILLISECONDS);
				if (s != null) {
					System.out.println("Thread output" + s);
				}
			} catch (ExecutionException | InterruptedException ex) {
				ex.printStackTrace();
			} catch ( TimeoutException ex){
				System.out.println("Thread exception");
			}
				
		}
	}
}
