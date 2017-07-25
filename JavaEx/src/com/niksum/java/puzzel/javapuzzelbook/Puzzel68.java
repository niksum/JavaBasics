package com.niksum.java.puzzel.javapuzzelbook;

import java.util.Stack;

class X{
	static class Y{
		static String Z = "Black";
	}
	
	static C Y = new C();
}

class C{
	String Z = "Whilte";
}
//When a variable and a type have the same name and both are in
//scope, the variable name takes precedence
public class Puzzel68 {
	public static void main(String[] args) {
		System.out.println(X.Y.Z);
		
	}
}
