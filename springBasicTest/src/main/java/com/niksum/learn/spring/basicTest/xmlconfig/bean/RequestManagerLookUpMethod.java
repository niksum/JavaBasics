package com.niksum.learn.spring.basicTest.xmlconfig.bean;

public class RequestManagerLookUpMethod {
	private RequestHandlerLookUpMethod requestHandler;

	public void handleRequest() {
		requestHandler = getRequestHandler();
		requestHandler.handleRequest();
		
	}

	//dummy implementation configure as look-up method
	public RequestHandlerLookUpMethod getRequestHandler() {
		return null;		
	}
	
}