package com.niksum.java;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Test5 {
	public static void main(String[] args) {
		Double total = new Double(2343);
		Double half = total/2;
		System.out.println("test");
		Predicate<String> predicateObj = t -> t.equalsIgnoreCase("Nikhil");
		System.out.println(predicateObj.test("Nikhil"));
		
		List<Integer> intList = Arrays.asList(4,5,7,1,3,88,98,56,43,4,5,3);
		
		System.out.println(intList.stream()
		.count());
		
		intList.stream().distinct().forEach(element -> System.out.println(element));
		
		System.out.println(intList.stream().allMatch(element -> element > 0));
	}
}
