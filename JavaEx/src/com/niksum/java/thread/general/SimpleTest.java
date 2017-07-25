package com.niksum.java.thread.general;

public class SimpleTest {
	public static void main(String[] args) {
		String abc= "69$";
		System.out.println(abc.replaceAll("\\$", ""));
		System.out.println(abc.replace("\\$", ""));
		System.out.println(abc.replaceAll("$", ""));
		System.out.println(abc.replace("$", ""));
	}
}
