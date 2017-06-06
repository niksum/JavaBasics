package com.niksum.java.puzzel;

public class StrutureExample {
	public static void main(String ag[]){
		pyramidStrut(6);
	}
	
	public static void pyramidStrut(int height){
		System.out.println("Left hand pyramid");
		for (int i = 0; i < height; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("Reverse left hand pyramid");
		for (int i = 0; i < height; i++) {
			for (int j = height; j > i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("Right hand pyramid");
		for (int i = height; i > 0 ; i--) {
			for (int j = 0; j <= height ; j++) {
				if(i<=j)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
		
		System.out.println("Reverse right hand pyramid");
		for (int i = height; i > 0 ; i--) {
			for (int j = height; j > 0 ; j--) {
				if(i-j>=0)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
		
		System.out.println("Pyramid");
		for (int i = height; i > 0 ; i--) {
			for (int j = height; j > 0 ; j--) {
				if(i-j>=0)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}
