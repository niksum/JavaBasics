package com.niksum.java.operator;

public class PipeOperatorEx {
	static int x;
	static boolean catcha(){
		x++;
		return true;
	}
	public static void main(String[] args) {
		
		x=0;
		if((catcha()|catcha()) || catcha())
			x++;
		System.out.println(x);
	}
}
