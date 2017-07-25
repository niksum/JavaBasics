package com.niksum.java.puzzel.javapuzzelbook;

public class Puzzel12 {
	public static void main(String[] args) {
		String ab = "AB";
		char[] bc = {'1','2','3'};
		System.out.println(ab + " as " + bc);
		
		final String pig = "length: 10";
		final String dog = "length: "+pig.length();
		System.out.println("Animal are equal "+ pig == dog);  
		// it is equal to (animal are equal + pig) == dog
		//When using the string concatenation operator, always parenthesize nontrivial operands.
		
		System.out.println("H" + "a");
		System.out.println('h' + 'a');
		//The + operator performs string concatenation if and only if at least one of its operands is of type String;
		
		
		//Unicode escapes must be well formed, even if they appear in comments.
		/*
		 * this is a test comment ah backward slash will not work here units
		 */
		System.out.print("Hell");
		System.out.println("o world");
	}
	
}
