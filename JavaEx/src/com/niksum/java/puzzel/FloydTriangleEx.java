package com.niksum.java.puzzel;

public class FloydTriangleEx {
	public static void main(String[] args) {
		int out = 1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(out++);
			}
			System.out.println();
		}
	}
}
