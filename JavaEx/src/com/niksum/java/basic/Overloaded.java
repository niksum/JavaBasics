package com.niksum.java.basic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Overloaded {
	public static void main(String[] args) {
		int a = 1 << 30;
		System.out.println(a);
		int ab = 0;
		
		//If you are passing primitive data type as an argument to the method call, 
		//compiler first checks for a method definition which takes same data type as an argument.
		overload(10);
		
		//If such method does not exist, then it checks for the method definition which takes big sized
		//primitive data type than passed data type. i.e It tries to perform auto-widening conversion of passed data type.
		autoWidening(ab);
		
		//If auto-widening conversion is not possible, then it checks for method definition which takes 
		//corresponding wrapper class type as an argument. i.e It tries to perform auto-boxing conversion.
		autoBoxing(7);
		
		//If such method does not exist, then it checks for the method which takes super class type (Number or Object type) as an argument.
		//If such method also does not exist, then compiler gives compile time error.
		autoUpCasting(18);
		
		// in case we have autupcasting and primitive option it will go to autoupcasting
		Integer dd = new Integer(87);
		checkOver(dd);
		
		// in case of auto widening and primitive option it will go to primitive
		Integer dwd = new Integer(87);
		checkAgain(dwd);
		// autonarrowing will not work in case of primitive or wrapper
		wowCheck(87l);
		
		//downCasting or unboxing did not work in overloading
		Number n = new Integer(3);
//		wrappOrPrimi(n);
		
		
		//Widening of primitive type has taken priority over boxing and var-args. But widening and boxing of primitive type can not work together.
		//But boxing followed by widening is acceptable
		
		byte val =4;
		boxAndWiden(val);
		
		// Below example show that widening is getting priority even In case it need to widen 2 or 3 times also 
		byte abc = 23;
		doubleWidening(23);
		
		int oid = 98;
		tripleWidening(oid);
	}
	
	public static void tripleWidening(double ad){
		System.out.println("double tripleWidening");
	}
	
	public static void tripleWidening(Integer ad){
		System.out.println("Integer tripleWidening");
	}
	
	public static void doubleWidening(int a){
		System.out.println("int doubleWidening");
	}
	
	public static void doubleWidening(Byte a){
		System.out.println("Byte doubleWidening");
	}

	public static void boxAndWiden(Object o){
		System.out.println("Object boxAndWiden");
	}
	
	public static void boxAndWiden(Integer o){
		System.out.println("Integer boxAndWiden");
	}
	
	public static void wrappOrPrimi(Integer i){
		System.out.println("Integer wrappOrPrimi");
	}
	
	public static void wrappOrPrimi(int ii){
		System.out.println("int wrappOrPrimi");
	}
	
	public static void wowCheck(Number a){
		System.out.println("Number wowCheck");
	}
	
	public static void wowCheck(Integer a){
		System.out.println("Integer wowCheck");
	}
	
	public static void checkAgain(int a){
		System.out.println("int checkAgain");
	}
	
	public static void checkAgain(Long a){
		System.out.println("Long checkAgain");
	}
	
	public static void checkOver(Number a){
		System.out.println("Number checkOver");
	}
	
	public static void checkOver(int a){
		System.out.println("int checkOver");
	}
	
	public static void autoUpCasting(Number a){
		System.out.println("Number autoUpCasting");
	}
	
	public static void autoUpCasting(Long a){
		System.out.println("Long autoUpCasting");
	}
	
	public static void autoUpCasting(Double a){
		System.out.println("Double autoUpCasting");
	}
	
	public static void overload(int a){
		System.out.println("int overload");
	}
	
	public static void overload(Integer a){
		System.out.println("Integer overload");
	}
	
	public static void overload(Number a){
		System.out.println("Number overload");
	}
	
	public static void autoWidening(Integer i) {
		System.out.println("Integer autoWidening");
	}

	public static void autoWidening(long i) {
		System.out.println("long autoWidening");
	}
	
	public static void autoBoxing(Integer a){
		System.out.println("Integer autoboxing");
	}
	
	public static void autoBoxing(Long a){
		System.out.println("Long autoboxing");
	}
}
