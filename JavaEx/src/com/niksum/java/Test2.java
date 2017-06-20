package com.niksum.java;

import static java.lang.System.*;
public class Test2 {
	int power;
	static void fight(Test2 a, Test2 b){
		a = new Test2();
		a.power = 2;
		b.power = 4;
		b = new Test2();
	}
	
	public static void main(String[] args) {
		Test2 aa = new Test2();
		aa.power = 1;
		Test2 ba = new Test2();
		ba.power = 0;
		fight(ba, aa);
		out.println(aa.power);
		out.println(ba.power);
	}
}
