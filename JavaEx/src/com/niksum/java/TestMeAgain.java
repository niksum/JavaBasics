package com.niksum.java;

import java.util.HashSet;

public class TestMeAgain {
public static void main(String[] args) {
	int a[][]= new int[3][];
	a[0]= new int[1];
	a[1]= new int[2];
	a[2]= new int[3];
	int sum =0;
	for (int i = 0; i < 3; ++i) {
		for (int j = 0; j < i+1; ++j) {
			a[i][j]=j+1;
		}
	}
	for (int i = 0; i < 3; ++i) {
		for (int j = 0; j < i+1; ++j) {
			sum+=a[i][j];
		}
	}
	System.out.println(sum);
	int[] aa =  new int[2];
	System.out.println(aa);
	System.out.println(fun(4,3));
	try{
		System.out.println("a");
	} finally{
		System.out.println("b");
	} System.out.println("c");
	
	HashSet my = new HashSet();
	String add = new String("da");
	String add2 = new String("da");
	
	Mi mi1= new Mi("aa");
	Mi m2 = new Mi("aa");
	my.add(add);
	my.add(add2);
	my.add(mi1);
	my.add(m2);
	System.out.println(my);
}
static class Mi{
	String a;
	Mi (String a){
		this.a = a;
	}
	public String toString(){
		return a;
	}
}
static int fun(int a, int b)
{
	if(a==0)
		return b;
	return fun(a-1, a+b);
}
}
