package com.niksum.java.thread.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ProdConIns {
	private final Lock lock = new ReentrantLock();
	private final Condition notFull = lock.newCondition();
	private final Condition notEmpty = lock.newCondition();
	private final Random num = new Random();
	private final List<Integer> sharedRes = new ArrayList<>();

	public void produce() {
		try {
			lock.lock();

			while (sharedRes.size() == 5){
				System.out.println("Buffer is full, waiting");
				notEmpty.await();				
			}
			int number = num.nextInt();
			boolean isAdded = sharedRes.add(number);
			if(isAdded){
				System.out.println(number + " has been added into list. Current size is "+sharedRes.size());
				System.out.println("Sending signal to consumer");
				notFull.signal();
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void consume() {
		try {
			lock.lock();

			while (sharedRes.isEmpty()){
				System.out.println("Buffer is empty, waiting");
				notFull.await();
			}
			Integer intVa = sharedRes.remove(sharedRes.size() - 1);
			if(intVa != null){
				System.out.println (intVa + " it has been removed from the list.");
				System.out.println("Signaling to prod");
				notEmpty.signal();
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}

class Producer extends Thread {
	private ProdConIns ins;

	public Producer(ProdConIns ins) {
		this.ins = ins;
	}

	@Override
	public void run() {
		try {
			System.out.println("Producer");
			for (int i = 0; i < 10; i++) {
				ins.produce();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Consumer extends Thread {

	private ProdConIns ins;

	public Consumer(ProdConIns ins) {
		this.ins = ins;
	}

	@Override
	public void run() {
		try {
			System.out.println("consume");
			for (int i = 0; i < 10; i++) {
				ins.consume();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class ProdConsUsingLock {

	public static void main(String[] args) {
		ProdConIns ins = new ProdConIns();
		Producer p =new Producer(ins);
		Consumer c = new Consumer(ins);
		p.start();
		c.start();
	}
}
