package com.niksum.java.puzzel;

import java.util.Arrays;
import java.util.List;

public class ArrayExample {
	public static void main(String[] args) {
		Integer[] inputArray = {30,67,43,90,9,-9,3,23};
		findOutMinAndMax(Arrays.asList(inputArray));
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
