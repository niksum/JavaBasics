package com.niksum.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrefixSumArray {
	public static void main(String[] args) {
		int input[] = {1,5,10,2,5};
		printArray(input);
		printArray(createPrefixSumArrayOfInt(input));
		
		int inputForSubArray[]={1,2,-5,2,0,5,6};
		int inputForSubArray2[]={1,2,-6,2,7,5,6};
		System.out.println(isSubArrayWith0SumExists(inputForSubArray));
		System.out.println(isSubArrayWith0SumExists(inputForSubArray2));
	}
	
	private static int[] createPrefixSumArrayOfInt(int input[]){
		int prefixArray[] = new int[input.length];
		prefixArray[0]=input[0];
		for (int i = 1; i < input.length; i++) {
			prefixArray[i]=prefixArray[i-1]+input[i];
		}
		return prefixArray;
	}
	
	private static void printArray(int input[]){
		System.out.println(Arrays.toString(input));
	}
	
	private static boolean isSubArrayWith0SumExists(int input[]){
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < input.length; i++) {
			sum+=input[i];
			if(input[i]==0 || sum==0 || map.containsKey(sum))
				return true;
			
			map.put(sum, i);
				
		}
		
		return false;
	}
}
