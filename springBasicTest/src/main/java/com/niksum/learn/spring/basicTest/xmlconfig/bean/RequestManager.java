package com.niksum.learn.spring.basicTest.xmlconfig.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class RequestManager implements ApplicationContextAware{
	private RequestHandler requestHandler;
	private ApplicationContext context;

	public void handleRequest() {
//		requestHandler.handleRequest();
		requestHandler = getRequestHandler();
		requestHandler.handleRequest();
	}

	public RequestHandler getRequestHandler() {
//		return requestHandler;
		
		return context.getBean("reqHand", RequestHandler.class);
	}

//	public void setRequestHandler(RequestHandler requestHandler) {
//		this.requestHandler = requestHandler;
//	}
	
	

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
		
	}

}