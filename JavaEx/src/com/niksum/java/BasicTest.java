package com.niksum.java;

import java.math.BigDecimal;

public class BasicTest {
	public static void main(String[] args) {
//		System.out.println(2 - 1.10);
//		findOutOdd(7);
//		subtractionDouble();
//		divisionLong();
//		swaptWithoutTemp();
		concatinateChar();
		System.out.println(
				Long.toHexString(0x100000000L + 0xcafebabe));
		
	
	}
	
	public static void concatinateChar(){
		System.out.println('h'+'a');
		System.out.println("H" + "A");
		System.out.println("" + 'h' + 'a');
		System.out.println(new StringBuffer().append('h').append('a'));
		System.out.println("2 + 2 = "+ 2+2);
		System.out.println(2 + 2+ 2+2);
		System.out.println(2 + 2+ " = 2+2");
	}
	public static void divisionLong(){
		final long micros = 24*60*60*1000*1000;
		final long millis =  24*60*60*1000;
		System.out.println(micros/millis);
		//above will not give correct result as it is going as the first thing is 
		//too much and not going to fit in INT. Reason the mulitplication are in int 
		//so it will give int result.
		
		// it can be fixed by specifically mentioning it is long.
		final long microsL = 24L*60*60*1000*1000;
		final long millisL =  24L*60*60*1000;
		System.out.println(microsL/millisL);
		//When working with large numbers, watch out for
		//overflow—it’s a silent killer.
	}
	
	public static void findOutOdd(int nu){
		System.out.println((nu % 2)==1); // not going to work with -ver number
		System.out.println((nu % 2)!=0); // it will work.
		System.out.println((-3& 1) !=0); // best solution and fastest one
	}
	
	public static void subtractionDouble(){
		System.out.println(2.00-1.10); // will not give precise result
		// for monetary calculation better to use int, long or BigDecimal
		System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.10")));
				
	}
	public static void swaptWithoutTemp(){
		int a = 98;
		int b = 77;
		
		a = a+b;
		b = a-b;
		a = a-b;
		System.out.println(a + "  " + b);
	}
	
}
