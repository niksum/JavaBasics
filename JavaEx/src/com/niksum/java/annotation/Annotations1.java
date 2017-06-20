package com.niksum.java.annotation;

public class Annotations1 {
	{
		System.out.println("like that");
	}
	@interface Hi{}
	interface Lo extends Hi{}
	Lo hi = ()->Hi.class;
	
	{
		System.out.println(hi.annotationType());
	}
	
	public static void main(String[] args) {
		new Annotations1();
	}
}
