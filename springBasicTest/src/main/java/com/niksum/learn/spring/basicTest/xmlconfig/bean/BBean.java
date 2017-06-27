package com.niksum.learn.spring.basicTest.xmlconfig.bean;

public class BBean {
	private static int counter =  0;
	BBean(){
		System.out.println("construtor");
		System.out.println("counter "+ ++counter);
	}
	public void methodOfBBean(){
		System.out.println("BBean method calling");
	}
}
