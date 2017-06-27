package com.niksum.learn.spring.basicTest.xmlconfig.bean;

public class BPrototypeBean {
	private static int counter = 0;
	BPrototypeBean(){	
		System.out.println("BPrototypeBean con");
		System.out.println("BP counter " + ++counter);
	}
}
