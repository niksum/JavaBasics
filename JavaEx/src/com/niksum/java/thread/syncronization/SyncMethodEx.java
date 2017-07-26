package com.niksum.java.thread.syncronization;
class Wisher {
	public synchronized void wish(String msg){
		System.out.println("Wishig you "+msg);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static synchronized void wishList(String msg){
		System.out.println("wishList for you "+msg);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void wishWow(String msg){
		System.out.println("wishWow for you "+msg);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void wishMe(String msg){
		System.out.println("wishMe you "+msg);
		try {
			wishWow(msg);
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class WishGreet extends Thread {

	private Wisher wisher;
	private String message;
	
	public WishGreet(Wisher wish, String mess){
		this.wisher = wish;
		this.message = mess;
	}
	
	@Override
	public void run(){
		System.out.println("Inside run method");
		wisher.wishList(message);
	}
}

class Greet extends Thread{
	
	private Wisher wisher;
	private String message;
	
	public Greet(Wisher wish, String mess){
		this.wisher = wish;
		this.message = mess;
	}
	
	@Override
	public void run(){
		System.out.println("Inside run method");
		wisher.wish(message);
	}
}


class WishWow extends Thread {

	private Wisher wisher;
	private String message;
	
	public WishWow(Wisher wish, String mess){
		this.wisher = wish;
		this.message = mess;
	}
	
	@Override
	public void run(){
		System.out.println("Inside run method");
		wisher.wishMe(message);
	}
}

class WishMee extends Thread {

	private Wisher wisher;
	private String message;
	
	public WishMee(Wisher wish, String mess){
		this.wisher = wish;
		this.message = mess;
	}
	
	@Override
	public void run(){
		System.out.println("Inside run method");
		wisher.wishWow(message);
	}
}
public class SyncMethodEx {
	public static void main(String[] args) {
//		syncMethodOnSameObjectEx();
		// In above case as we are working on same object on two different thread and calling
		// a sync method so 2nd thread calling same method has to wait for getting a free lock on 
		// Wish object
		
//		syncMethodOnDiffObjectEx();
		// In above case we are having two different object being used in different thread so it
		// it will not wait for lock to acquire as it is object level locking.
		
		
//		statSyncMethoOnSameObjectEx();
		
		// In above case as we are working on same object on two different thread and calling
		// a static sync method so 2nd thread calling same method has to wait for getting a 
		// free lock of Class level 
		// Wish 
		
		
//		statSyncMethoOnDiffObjectEx();
		// In above case although we have two different object of Wisher but still as 
		// syncronization is on static method so it is locking at class level
		// so it will wait
		
		
//		mixingSyncCalls();
		//in case we are mixing class and object level syncy they will work concurently
		
		
		callingNonSyncFroSync();
	}
	
	private static void callingNonSyncFroSync() {
		Wisher wish1 = new Wisher();
		
		Thread greet1 = new WishWow(wish1,"Good morning");
		
		Thread greet2 = new WishWow(wish1,"Good morning again");
//		Thread greet3 = new WishMee(wish1,"Good evening");
		
		greet1.start();
		greet2.start();
//		greet3.start();
		
	}
	
	private static void mixingSyncCalls() {
		Wisher wish1 = new Wisher();
		
		Thread greet1 = new Greet(wish1,"Good morning");
		Thread greet2 = new WishGreet(wish1,"Good evening");
		
		greet1.start();
		greet2.start();
		
	}
	
	private static void statSyncMethoOnDiffObjectEx() {
		Wisher wish1 = new Wisher();
		Wisher wish2 = new Wisher();
		Thread greet1 = new WishGreet(wish1,"Good morning");
		Thread greet2 = new WishGreet(wish2,"Good evening");
		
		greet1.start();
		greet2.start();
	}
	
	private static void statSyncMethoOnSameObjectEx() {
		Wisher wish1 = new Wisher();
		Thread greet1 = new WishGreet(wish1,"Good morning");
		Thread greet2 = new WishGreet(wish1,"Good evening");
		
		greet1.start();
		greet2.start();
	}

	public static void syncMethodOnDiffObjectEx(){
		Wisher wish1 = new Wisher();
		Wisher wish2 = new Wisher();
		Thread greet1 = new Greet(wish1, "Good morning");
		Thread greet2 = new Greet(wish2, "Good evening");
		
		greet1.start();
		greet2.start();
	}
	
	public static void syncMethodOnSameObjectEx(){
		Wisher wish1 = new Wisher();
		Thread greet1 = new Greet(wish1, "Good morning");
		Thread greet2 = new Greet(wish1, "Good evening");
		
		greet1.start();
		greet2.start();
	}
}
