package com.niksum.java.thread.barrier;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
	private static Semaphore sem = new Semaphore(3);

	static class ATMThread extends Thread {
		public String name;

		public ATMThread(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			try {
				System.out.println(name + " Acqiring lock.");
				System.out.println(sem.availablePermits() + " # Available semaphore permits.");
			
					sem.acquire();
				
				System.out.println(name +" Got the permit for ");
				try {
					for (int i = 0; i < 4; i++) {
						System.out.println("\t \t"+ name + " Performing operation " + i + ", available semaphore permits : "
								+ sem.availablePermits());
						Thread.sleep(300);
					}
				} finally {
					System.out.println(name + " Releasing lock");
					sem.release();
					System.out.println(sem.availablePermits() + " Release . Available semaphore permits");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			ATMThread thread = new ATMThread("Thread#" + i);
			thread.start();
		}
	}
}
