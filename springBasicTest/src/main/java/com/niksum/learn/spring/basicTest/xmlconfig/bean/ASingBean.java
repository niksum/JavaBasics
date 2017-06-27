package com.niksum.learn.spring.basicTest.xmlconfig.bean;

public class ASingBean {
	private static int counter =  0;
	ASingBean(){
		System.out.println("construtor ASingBean");
		System.out.println("counter "+ ++counter);
	}
	public void methodOfABean(){
		System.out.println("ASingBean method calling");
	}
}
