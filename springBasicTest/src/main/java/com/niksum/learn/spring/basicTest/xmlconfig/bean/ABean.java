package com.niksum.learn.spring.basicTest.xmlconfig.bean;

public class ABean {
	private static int counter =  0;
	ABean(){
		System.out.println("construtor");
		System.out.println("counter "+ ++counter);
	}
	public void methodOfABean(){
		System.out.println("ABean method calling");
	}
}
