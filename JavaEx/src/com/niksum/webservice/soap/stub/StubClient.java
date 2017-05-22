package com.niksum.webservice.soap.stub;

public class StubClient {
 public static void main(String[] args) {
	HelloWorldImplService service = new HelloWorldImplService();
	HelloWorld hello = service.getHelloWorldImplPort();
	System.out.println(hello.getHelloWorld("where I"));
}
}
