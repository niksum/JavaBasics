package com.niksum.java.algorithm;

import java.util.Arrays;

class A{
	protected int ab=9;
	final public void  methoda(){
		
	}
}
class B extends A{
	int ab =9;
	public void method(){
		
	}
}
public class Test {
	
	
	public static void pairPencils(int[] pencils) {
		Arrays.sort(pencils);
		int i = pencils.length/2;
		int j = pencils.length - 1;
		int pairs = 0;
		while (i  > 0) {
			if (2*pencils[i] <= pencils[j]) {
				pairs++;
				j--;
			} 
			i--;
		}
		System.out.println(pairs+" "+(pencils.length - pairs * 2));
	}
	public static int a =9;
	static{
		a = 10;
		System.out.println(a);
	}
 public static void main(String[] args) {
	int [] pensit = {1,2,3,4,5};
	 pairPencils(pensit);
	
}
}
