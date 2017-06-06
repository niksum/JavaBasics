package com.niksum.java.puzzel;

import java.util.Stack;

public class StringExample {
	public static void main(String[] args) {
//		reverseStrigCharacter("Hello world : where are you");
		reverseStringWords("Hello world : where are you.");
	}
	
	public static void reverseStrigCharacter(String abc){
		System.out.println("Reverse Strig Character");
		String input = abc;
		StringBuilder sbuil = new StringBuilder(input).reverse();
		System.out.println("\t *** Using StringBuilder method approach.");
		System.out.println("\t Input ->> "+abc +" reverse is >>>>> "+sbuil);
		
		StringBuilder sbuil1 = new StringBuilder();
		for (int i = input.length()-1; i >= 0; i--) {
			sbuil1.append(input.charAt(i));
		}
		System.out.println("\t *** Using StringBuilder approach.");
		System.out.println("\t Input ->> "+abc +" reverse is >>>>> "+sbuil1);
	
		char[] charArr = abc.toCharArray();
		int end = charArr.length-1;
		int begin =0;
		char tempChar;
		while(end > begin){
			tempChar = charArr[end];
			charArr[end] = charArr[begin];
			charArr[begin] = tempChar;
			end --;
			begin ++;
		}
		
		System.out.println("\t *** Using Character Array approach.");
		System.out.println("\t Input ->> "+abc +" reverse is >>>>> "+ new String(charArr));
		
		Stack<Character> revStack = new Stack<>();
		for (int i = 0; i < abc.length(); i++) {
			revStack.push(abc.charAt(i));
		}
		StringBuilder sb = new StringBuilder(); 
		while(!revStack.empty()){
			sb.append(revStack.pop());
		}
		
		System.out.println("\t *** Using Stack approach.");
		System.out.println("\t Input ->> "+abc +" reverse is >>>>> "+ sb);
	}
	
	public static void reverseStringWords(String inputSt){
		System.out.println("Reverse Strig words");
		String[] wordsArr = inputSt.split(" ");
		StringBuilder output = new StringBuilder();
		for (int i = wordsArr.length-1; i >= 0; i--) {
			output.append(wordsArr[i]).append(" ");
		}
		System.out.println("\t *** Using Word Array approach.");
		System.out.println("\t Input ->> "+inputSt +" reverse is >>>>> "+ new String(output));
	}
	

}
