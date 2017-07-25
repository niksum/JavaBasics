package com.niksum.java.thread.lock;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PhilospherProblem {
	public static class ChopStic {
		Lock up = new ReentrantLock(true);
		private final int id;

		public ChopStic(int id) {
			this.id = id;
		}

		public boolean pickUp(Philosopher who, String where) throws InterruptedException {
			if (up.tryLock(10, TimeUnit.MILLISECONDS)) {
				System.out.println(who + " pickup up " + where + " " + this);
				return true;
			}
			return false;
		}

		public void pickDown(Philosopher who, String name) {
			up.unlock();
			System.out.println(who + " put donw " + name + " " + this);
		}

		@Override
		public String toString() {
			return "Chopstic-" + id;
		}
	}

	public static class Philosopher implements Runnable {

		private final int id;
		private final ChopStic leftCS, rightCS;

		volatile boolean isTummyFull = false;
		private Random randomGenerator = new Random();
		private int noOfTurnsToEat = 0;

		public Philosopher(int id, ChopStic leftCS, ChopStic rightCS) {
			this.id = id;
			this.rightCS = rightCS;
			this.leftCS = leftCS;
		}

		private void think() throws InterruptedException {
			System.out.println(this + " is thinking");
			Thread.sleep(randomGenerator.nextInt(1000));
		}

		private void eat() throws InterruptedException {
			System.out.println(this + " is eating");
			noOfTurnsToEat++;
			Thread.sleep(randomGenerator.nextInt(1000));			
		}

		// Accessors at the end.
		public int getNoOfTurnsToEat() {
			return noOfTurnsToEat;
		}

		@Override
		public void run() {
			try {
				while (!isTummyFull) {
					think();
					if (leftCS.pickUp(this, "left")) {
						if (rightCS.pickUp(this, "right")) {
							eat();

							rightCS.pickDown(this, "right");
						}
						leftCS.pickDown(this, "left");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public String toString() {
			return "Philosopher-" + id;
		}
	}

	private static final int NoOfPhilosopher = 10;
	private static final int stimulationMillis = 1000*5;
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService ser = null;
		Philosopher[] phils = null;
		try{
		phils = new Philosopher[NoOfPhilosopher];
		ChopStic[] cSs = new ChopStic[NoOfPhilosopher];
		for (int i = 0; i < NoOfPhilosopher; i++) {
			cSs[i] = new ChopStic(i);
		}
		
		ser = Executors.newFixedThreadPool(NoOfPhilosopher);
		
		for (int i = 0; i < NoOfPhilosopher; i++) {
			phils[i] = new Philosopher(i, cSs[i], cSs[(i+1)% NoOfPhilosopher]);
			ser.execute(phils[i]);
		}
		
		Thread.sleep(stimulationMillis);
		for (Philosopher phil : phils) {
			phil.isTummyFull = true;
		}
	} finally{
		ser.shutdown();
		while (!ser.isTerminated()) {
	        Thread.sleep(1000);
	      }

	      // Time for check
	      for (Philosopher philosopher : phils) {
	        System.out.println(philosopher + " => No of Turns to Eat ="
	                + philosopher.getNoOfTurnsToEat());
	      }
	}
	}

}
