package com.niksum.java.thread.general;

public class DeadLockCondition {
	private static Object firstResource = new Object();
	private static Object secondResource = new Object();
	
	public static void main(String[] args) {
		Thread eater1 = new Thread(new Hungery());
		Thread eater2 = new Thread(new AnotherHungery());
		
		eater1.start();
		eater2.start();
	}
	
	private static class Hungery implements Runnable{
		@Override
		public void run(){
			synchronized(firstResource){
				System.out.println("Getting locked on first resource");
				try {
					System.out.println("Doing processing on resource");
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Tryring to get access to second resource");
				synchronized (secondResource) {
					System.out.println("Getting locked on second resource");
				}
			}
		}
	}
	
	private static class AnotherHungery implements Runnable{
		@Override
		public void run(){
			synchronized(secondResource){
				System.out.println("Getting locked on second resource");
				try {
					System.out.println("Doing processing on resource");
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Tryring to get access to first resource");
				synchronized (firstResource) {
					System.out.println("Getting locked on first resource");
				}
			}
		}
	}
}
