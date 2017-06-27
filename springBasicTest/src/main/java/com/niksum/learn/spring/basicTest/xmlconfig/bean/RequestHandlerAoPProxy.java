package com.niksum.learn.spring.basicTest.xmlconfig.bean;

public class RequestHandlerAoPProxy {

	RequestHandlerAoPProxy() {
		System.out.println("In Request Handler Constructor");
	}

	public void handleRequest() {
		System.out.println("Handling request");
	}
}
