package com.niksum.java.puzzel;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrintingReverse {
	public static void main(String[] args) {
//		reverseNumber();
//		reverseElementOfStringArray();
//		reverseListOfStringArray();
//		reverseSpecificSubstringPart();
		sortSpecificSubstringPart();
	}
	
	private static void reverseSpecificSubstringPart(){
		String[] input = {"water","air","solid"};
		Arrays.asList(input)
		.replaceAll(s -> new StringBuffer(s)
				.replace(0, 3, new StringBuffer(s.substring(0, 3))
						.reverse()
						.toString())
				.toString());
		
		System.out.println(Arrays.toString(input));
	}
	
	private static void sortSpecificSubstringPart(){
		//.sort("adfdafd");
		String[] input = {"water","air","solid"};
		Arrays.asList(input)
		.replaceAll(s -> new StringBuffer(s)
				.replace(0, 3, method(s)).toString());
		
		System.out.println(Arrays.toString(input));

	}
	
	private static String  method(String s){
		
			char[] temp = s.substring(0, 3).toCharArray(); 
			Arrays.sort(temp);
			return String.valueOf(temp);
	}
	
	private static void reverseListOfStringArray(){
		String[] input = {"water","air","solid"};
		Stream.of(input)
		.collect(Collectors.toCollection(LinkedList::new))
		.descendingIterator()
		.forEachRemaining(System.out::println);
	}
	
	private static void reverseElementOfStringArray(){
		String[] input = {"water","air","solid"};
		Arrays.asList(input)
		.replaceAll(s -> new StringBuffer(s).reverse().toString());
		
		System.out.println(Arrays.toString(input));
		
	}
	
	public static void reverseNumber(){
		System.out.println("reverseNumber");
		Integer input = 987654;
		StringBuffer reverse = new StringBuffer();
		while(input > 0){
			int last = input % 10;
			input = input/10;
			reverse = reverse.append(last);
		}
		
		System.out.println(new Integer(reverse.toString()));
	}
}
