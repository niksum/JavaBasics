package com.niksum.java.puzzel.javapuzzelbook;

class MyString {
	private final java.lang.String s;
	public MyString(java.lang.String in){
		this.s = in;
	}
	public java.lang.String toString(){
		return s;
	}
}
//Avoid reusing the names of platform classes, and never reuse class names from java.lang,
public class Puzzel67 {
	public static void main(String[] args) {
		String s = new String("hello wo");
		System.out.println(s);
	}
}
