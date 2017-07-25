package com.niksum.java.thread.procon;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProdConsUsingBlockingQueue {
	BlockingQueue<Integer> taskQueue = new LinkedBlockingQueue<>();

	class Producer implements Runnable {
		public Producer() {
			System.out.println("Producer con");
		}

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					System.out.println("Produced element " + i);
					taskQueue.put(i);
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	class Consumer implements Runnable {
		public Consumer() {
			System.out.println("Consumer con");
		}

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					System.out.println("Consumer element " + taskQueue.take());
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {	
		ProdConsUsingBlockingQueue instance = new ProdConsUsingBlockingQueue();
		Thread prod = new Thread(instance.new Producer());
		Thread cons = new Thread(instance.new Consumer());

		prod.start();
		cons.start();
	}
}
