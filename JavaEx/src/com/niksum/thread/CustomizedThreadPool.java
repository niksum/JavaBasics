package com.niksum.thread;

import java.util.concurrent.BlockingDeque;
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
	private static class PoolWorker extends Thread{
		@Override
		public void run(){
			
		}
	}
}

public class CustomizedThreadPool {

}
