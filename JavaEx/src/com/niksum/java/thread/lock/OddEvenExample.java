package com.niksum.java.thread.lock;

import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenExample {
	private static Lock lock;
	private static Condition oddCondition, evenCondition;

	public static void main(String[] args) {
		lock = new ReentrantLock();
		oddCondition = lock.newCondition();
		evenCondition = lock.newCondition();

		ExecutorService service = Executors.newFixedThreadPool(2);
		Future oddThread, evenThread;

		evenThread = service.submit(new EvenThread());
		oddThread = service.submit(new OddThread());
		
		service.shutdown();
		
	}

	private static class EvenThread implements Runnable {

		@Override
		public void run() {
			try {
				lock.lock();
				for (int i = 0; i < 10; i++) {
					if (i % 2 == 0){
						System.out.println(Thread.currentThread().getName() + " printing = " + i);
						evenCondition.await();						
					}
					else if(i%2!=0){
						System.out.println(Thread.currentThread().getName()
								+ " Current number is odd so sending to signal to another thread");
						oddCondition.signal();
					}
				}
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			} finally{
				lock.unlock();
			}
		}
	}
	
	private static class OddThread implements Runnable {
		
		@Override
		public void run() {
			try {
				lock.lock();
				for (int i = 0; i < 10; i++) {
					if (i % 2 != 0){
						System.out.println(Thread.currentThread().getName() + " printing = " + i);
						oddCondition.await();
					}
					else if(i% 2==0){
						System.out.println(Thread.currentThread().getName()
								+ " Current number is even so sending to signal to another thread");
						evenCondition.signal();
						
					}
				}
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			} finally{
				lock.unlock();
			}
		}
	}
}
