package com.niksum.java.basic.construct;

class A{
	int x = 1;
	A(){
		System.out.println(this);
	}
	
	int getX(){
		return x;
	}
	
	public String toString(){
		return getClass().getSimpleName() + getX();
	}
}

class B extends A{
	int x = 2;
	B(){
		System.out.println(this);
	}
	
	int getX(){
		return x;
	}
}
public class InheritanceEx {
	public static void main(String[] args) {
		A a = new B();
		
	}
}
