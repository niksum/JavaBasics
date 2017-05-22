package com.niksum.webservice.soap.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.niksum.webservice.soap.HelloWorld;

public class HelloWorldClient {
	public static void main(String[] args) throws Exception{
		URL url = new URL("http://localhost:8888/ws/hello?wsdl");
		QName qname = new QName("http://soap.webservice.com/", "HelloWorldImplService");
		Service service = Service.create(url, qname);
		HelloWorld client = service.getPort(HelloWorld.class);
		System.out.println(client.getHelloWorld("agg"));
	}
}
