package com.niksum.java.thread.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantRWLEx {
	private static int count =0;
	private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
	
	private static class Producer implements Runnable{
		private ReentrantReadWriteLock.WriteLock write = null;
		private String prodNm = null;
		public Producer(ReentrantReadWriteLock.WriteLock _write, String nm){
			write = _write;
			prodNm = nm;
		}
		
		@Override
		public void run() {
			System.out.println("<<<<< Producer "+ prodNm +"  run method");
			write.lock();
			System.out.println("<<<<< Producer "+ prodNm +"  got locked");
			for (int i = 0; i < 5; i++) {
				System.out.println("<<<< Producer "+ prodNm +"  counting  "+count++);
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("<<<<< Producer "+ prodNm +" unlocking");
			write.unlock();
		}
	}
	
	private static class Consumer implements Runnable{
		private ReentrantReadWriteLock.ReadLock read = null;
		private String conNm = null;
		
		public Consumer(ReentrantReadWriteLock.ReadLock _read, String name){
			read = _read;
			conNm = name;
		}
		
		@Override
		public void run() {
			System.out.println(">>>>> Consumer "+ conNm + " run method");
			read.lock();
			System.out.println(">>>>> Consumer "+ conNm + " got locked");
			System.out.println(">>>>> Consuer " + conNm + " count is "+count);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(">>>>> Consumer " + conNm +" unlocking");
			read.unlock();
		}
	}
	
	public static void main(String[] args) {
		Thread prodThread = new Thread(new Producer(lock.writeLock(), "First"));
		Thread conThread1 = new Thread(new Consumer(lock.readLock(), " First"));
		Thread conThread2 = new Thread(new Consumer(lock.readLock(), " Second"));
		Thread prodThread2 = new Thread(new Producer(lock.writeLock(), "Second"));
		conThread1.start();
		conThread2.start();
		prodThread.start();
		prodThread2.start();
	}
}
