package com.niksum.java.collections.concurrent;

import java.util.concurrent.SynchronousQueue;

public class SyncronousQueueExample {
	public static void main(String[] args) {
		final SynchronousQueue<String> queue = new SynchronousQueue<String>(true);
		Thread producer = new Thread(()->{
			String event = "First put";
			try{
				queue.put(event);
				System.out.printf("[%s] published event %s %n",Thread.currentThread().getName(),event);
			} catch(Exception e){
				System.out.println("Exception in producer");
			}
		},"Producer");
		
		producer.start();
		
		Thread consumer = new Thread(()->{
			try{
				String event= queue.take();
				System.out.printf("[%s] consumed event : %s %n", Thread .currentThread().getName(), event);
			} catch(Exception e ){
				System.out.println("Exception in consumer");
			}
		},"Consumer");
		
		consumer.start();
	}
}

