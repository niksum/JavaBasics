package com.niksum.java.collections.concurrent;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueuExample {
	public static void main(String[] args) {
		basicOperation();
	}
	
	private static void charArray(){
		char[] input = {'a','b','c'};
		char[] input2 = null; 
		basicCheck(input);
		basicCheck(input2);
		Character[] input3 = {'a','b','c'};
		Character[] input4 = null;
		Character input5 = 'a';
		Object[] input6 = null;
		char input7 = 'a';
		basicCheck(input3);
		basicCheck(input4);
		
//		basicCheck(input5);
		basicCheck(input6);
//		basicCheck(input7);
	}
	
	private static void basicCheck(char... ab){
		System.out.println("char");
	}

	private static void basicCheck(Object... ab){
		System.out.println("object ");
	}

	private static void basicOperation(){
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		queue.add(14);
		queue.add(4);
		queue.add(3454);
		queue.add(44);
		queue.add(4);
		queue.add(0);
		queue.add(64);
		System.out.println(queue.peek());
		  while (!queue.isEmpty()) {
	            System.out.println(queue.poll());
	        }
	}
}
