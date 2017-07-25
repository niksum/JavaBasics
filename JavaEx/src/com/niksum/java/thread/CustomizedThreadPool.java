package com.niksum.java.thread;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

class ThreadPool{
	private final int noThread;
	private final BlockingDeque<Runnable> queue;
	private final PoolWorker[] threads;
	public ThreadPool(int nThread){
		noThread = nThread;
		queue = new LinkedBlockingDeque<>();
		threads = new PoolWorker[nThread];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new PoolWorker();
			threads[i].start();
		}
	}
	
	public void execute(Runnable task){
		synchronized(queue){
			queue.add(task);
			queue.notify();
		}
	}
	
	private class PoolWorker extends Thread{
		@Override
		public void run(){
			Runnable task;
			while(true){
				synchronized(queue){
					while(queue.isEmpty()){
						try {
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					task = queue.poll();
				}
				try{
				task.run();
				} catch(RuntimeException e){
					System.out.println("Runtime ex" + e.getMessage());
				}
			}
		}
	}
}

class Task implements Runnable{
	private int num;
	
	public Task(int num){
		this.num = num;
	}
	@Override 
	public void run(){
		System.out.println("Task " + num + " is running. ");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class CustomizedThreadPool {
	public static void main(String[] args) {
		ThreadPool pool = new ThreadPool(4);
		for (int i = 0; i < 6; i++) {
			Task task = new Task(i);
			pool.execute(task);
		}
		
		ExecutorService e = Executors.newFixedThreadPool(4);
	}
}
