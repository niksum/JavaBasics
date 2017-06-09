package com.niksum.java;

public class StringExample {
	public static String test = "";

	public static void main(String[] args) {
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new StringExample().test1(test);
		System.out.println(test);
	}

	void test1(String input) {
		test += " test @1 ..";
		test2(test);
	}

	void test2(String input) {
		test += " test @2 ..";
		test3(test);
	}

	void test3(String input) {
		test += " test @3 ..";
	}
}
