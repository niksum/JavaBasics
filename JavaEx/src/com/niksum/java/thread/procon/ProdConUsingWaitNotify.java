package com.niksum.java.thread.procon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Prod implements Runnable {
	private Queue<Integer> taskList = new LinkedList<>();
	private int maxSize;
	private String name;

	Prod(Queue<Integer> list, int size, String name) {
		this.name = name;
		this.taskList = list;
		this.maxSize = size;
		System.out.println("Creating the producer having name = " + name + " and size is " + size);
	}

	@Override
	public void run() {

		try {
			produceTask();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}

	}

	private void produceTask() throws InterruptedException {
		synchronized (taskList) {
			for (int j = 0; j < 10; j++) {

				while (taskList.size() >= 3) {
					System.out.println("<<<<<<Queue is has elements so going into wait task");
					taskList.wait();
				}

				taskList.add(j);
				System.out.println("<<<<<Added task# " + j + " into list");
				System.out.println("<<<<<List is " + taskList);
			
				taskList.notifyAll();
				Thread.sleep(1000);
			}
		}
	}
}

	class Cons implements Runnable {
		private Queue<Integer> taskList = new LinkedList<>();
		private int maxSize;
		private String name;

		Cons(Queue<Integer> list, int size, String name) {
			this.name = name;
			this.taskList = list;
			this.maxSize = size;
			System.out.println("Creating the consumer having name = " + name + " and size is " + maxSize);
		}

		@Override
		public void run() {

			try {
				consumerTask();

			} catch (InterruptedException e) {
				System.out.println(e.getMessage());

			}
		}

		private void consumerTask() throws InterruptedException {
			synchronized (taskList) {
				for (int j = 0; j < 10; j++) {

					while (taskList.isEmpty()) {

						System.out.println(">>>>>Task List is empty so going into wait task");
						taskList.wait();
					}

					System.out.println(">>>>Removed task value from the list. value is " + taskList.remove());
					System.out.println(">>>>list is " + taskList);
					taskList.notifyAll();
					Thread.sleep(1000);
				}
			}
		}
	
}

public class ProdConUsingWaitNotify {
	public static void main(String[] args) {
		Queue<Integer> taskList = new LinkedList<>();
		Thread producer = new Thread(new Prod(taskList, 5, "PROD"));
		Thread consumer = new Thread(new Cons(taskList, 5, "CONS"));

		producer.start();
		consumer.start();
	}
}
