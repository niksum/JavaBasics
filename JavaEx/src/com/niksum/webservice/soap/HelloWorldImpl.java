package com.niksum.webservice.soap;

import javax.jws.WebService;

@WebService(endpointInterface="com.webservice.soap.HelloWorld")
public class HelloWorldImpl implements HelloWorld{

	@Override
	public String getHelloWorld(String name) {
		return "Hey welecome "+name;
	}

}
