package com.niksum.learn.spring.basicTest.xmlconfig.bean;

public class RequestManagerAoPProxy {
	private RequestHandlerAoPProxy requestHandler;

	public void handleRequest() {
		requestHandler.handleRequest();
		
	}

	public RequestHandlerAoPProxy getRequestHandler() {
		return requestHandler;		
	}

	public void setRequestHandler(RequestHandlerAoPProxy requestHandler) {
		this.requestHandler = requestHandler;
	}
	
}