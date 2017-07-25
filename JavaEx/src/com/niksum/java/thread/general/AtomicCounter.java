package com.niksum.java.thread.general;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
	private static int counter = 0;

	private static AtomicInteger atomicCounter = new AtomicInteger(0);

	public static void main(String[] a) {
		// given below is normal way of doing operation that will lead to bad
		// result.
		class Incrementer implements Runnable {
			@Override
			public void run() {
				for (int i = 0; i < 1_000; i++) {
					counter++;
				}
			}
		}

		class Decrementer implements Runnable {
			@Override
			public void run() {
				for (int i = 0; i < 1_000; i++) {
					counter--;
				}
			}
		}

		ExecutorService service = Executors.newFixedThreadPool(8);
		List<Future<?>> fut = new ArrayList<>();

		try {

			for (int i = 0; i < 4; i++) {
				fut.add(service.submit(new Incrementer()));
			}
			for (int i = 0; i < 4; i++) {
				fut.add(service.submit(new Decrementer()));
			}

			fut.forEach(future -> {
				try {
					future.get();
				} catch (InterruptedException | ExecutionException e) {
					System.out.println(e.getMessage());
				}
			});

			System.out.println("counter value " + counter);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			service.shutdown();
		}

		// Given below we are going to redo things now by using Atomi CASing
		class AtomicIncrementer implements Runnable {
			@Override
			public void run() {
				for (int i = 0; i < 1_000; i++) {
					atomicCounter.incrementAndGet();
				}
			}
		}

		class AtomicDecrementer implements Runnable {
			@Override
			public void run() {
				for (int i = 0; i < 1_000; i++) {
					atomicCounter.decrementAndGet();
				}
			}
		}

		ExecutorService serviceForAtomic = Executors.newFixedThreadPool(8);
		List<Future<?>> futForAtomic = new ArrayList<>();

		try {

			for (int i = 0; i < 4; i++) {
				futForAtomic.add(serviceForAtomic.submit(new AtomicIncrementer()));
			}
			for (int i = 0; i < 4; i++) {
				futForAtomic.add(serviceForAtomic.submit(new AtomicDecrementer()));
			}

			futForAtomic.forEach(future -> {
				try {
					future.get();
				} catch (InterruptedException | ExecutionException e) {
					System.out.println(e.getMessage());
				}
			});

			System.out.println("Atomic counter value " + atomicCounter);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			serviceForAtomic.shutdown();
		}

	}
}
