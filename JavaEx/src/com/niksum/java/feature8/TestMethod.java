package com.niksum.java.feature8;

import java.util.stream.Stream;

public class TestMethod {
	public static String method1(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "method1";
	}
	public static String method2(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "method2";
	}
	public static String method3(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "method3";
	}
	
	public static void main(String[] args) {
		Stream.<Runnable>of(()->System.out.println(method3()), ()->System.out.println(method2()), ()->System.out.println(method1())).parallel().forEach(Runnable::run);
	}
}
