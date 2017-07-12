package com.niksum.java.puzzel;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ArrayExample {
	public static void main(String[] args) {
		Integer[] inputArray = {30,67,43,90,9,-9,3,23};
		findOutMinAndMax(Arrays.asList(inputArray));
		printArray();
	}
	
	public static void printArray(){
		int[] input = {4,5,6,3,2,566,89};
		System.out.println(input);
		System.out.println(Arrays.toString(input));
		Arrays.stream(input)
		.forEach(System.out::print);
		
		
		int[][] twoDim = {{3,5},{66,87},{890,765}};
		System.out.println(Arrays.deepToString(twoDim));
		
		//Arrays.deepToString works for 1 and multi dimentional array but not work
				// in case of single dimetional array of primitive
		
//		System.out.println(Arrays.deepToString(input));
	}

	public static void findOutMinAndMax(List<Integer> input) {
		int min=0; 
		int max =0;
		for (Integer integer : input) {
			if(integer<min)
				min = integer;
			else if(integer>max)
				max = integer;
		}
		System.out.println("Result minimum : "+min + " maximum : "+max);
		
	}
}
