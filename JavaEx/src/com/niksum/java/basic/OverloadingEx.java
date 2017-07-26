package com.niksum.java.basic;

import java.io.IOException;
import java.util.List;
import java.util.Map;

class Parent {
	public static void statMethod() {
		System.out.println("Parent.statMethod can not be override in child. It will be called method hiding");
	}

	public final void finalMethod() {
		System.out.println("Parent.FinalMethod can not be overridder");
	}

	private void privateMethod() {
		System.out.println(
				"Parent.Private method can't be orverride. You can narrower the access modifier in Child class."
						+ " So you can't go from Protected to Public and  default to  protected or public");
	}

	public Number returnType(List<String> input) throws IOException {
		System.out.println("Parent.returnType you can return Same object or its subclass.");
		return new Integer(3);
	}

	List<Map<? extends Number, String>> argumentsMethod(String a, String b, String c) throws Exception {
		System.out.println(
				"Parent.argumentMethod Generics paremetrized for return type does  matter in overrider. But syncronized dont");
		return null;
	}
}

class Child extends Parent {
	// @Override
	public static void statMethod() throws RuntimeException {
		System.out.println("Child.statMethod can not be override in child. It will be called method hiding");
	}

	public void privateMethod() {
		System.out.println("Child.privateMethod  it is new method tied to child and not an overriden method");
	}

	@Override
	public Integer returnType(List input) throws IOException, RuntimeException {
		System.out.println(
				"Child.returnType you can return Same object or its subclass. Can add more Uncheckedexception");
		return new Integer(3);
	}

	@Override
	public synchronized List argumentsMethod(String a, String b, String c) throws IOException {
		System.out.println(
				"Child.argumentMethod if syncronized it will still be overrider and if we are moving to Raw collection it will also works"
						+ " Sending another exception will also works.");

		return null;
	}
}

public class OverloadingEx {
	public static void main(String[] args) throws Exception{
		Parent parentRef = new Parent();
		Parent childRef = new Child();
		
		parentRef.statMethod();
		parentRef.finalMethod();
		parentRef.returnType(null);
		parentRef.argumentsMethod("", "", "");
		
		
		childRef.statMethod();
		childRef.finalMethod();
		childRef.returnType(null);
		childRef.argumentsMethod("", "", "");
		
		
	}
}
