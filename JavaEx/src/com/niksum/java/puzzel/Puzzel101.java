package com.niksum.java.puzzel;

public class Puzzel101 {
	public static void main(String[] args) {
		method1();
	}
	
	private static void method1(){
		long start = System.nanoTime();
		for (int i = 0; i < 1_000_000; i++) {
			
		}
		long end = System.nanoTime();
		
		System.out.println(end-start);
		
		long start2 = System.nanoTime();
		for (int i = 1_000_000; i > 0; i--) {
			
		}
		long end2 = System.nanoTime();
		System.out.println(end2-start2);
				
	}
}
