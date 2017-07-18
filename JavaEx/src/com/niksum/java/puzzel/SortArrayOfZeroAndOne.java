package com.niksum.java.puzzel;

import java.util.Arrays;

public class SortArrayOfZeroAndOne {
	public static void main(String[] args) {
		int[] array = {1,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0};
		int start = 0;
		int last = array.length-1;
		while(start < last){
			if(array[start]==0)
				start++;
			else if(array[start]==1){
				if(array[last]==0){
					array[last--] = 1;
					array[start++] = 0;
				} else
					last--;
			}
			if(array[last]==1)
				last--;
			else if(array[last]==0){
				if(array[start]==1){
					array[last--] = 1;
					array[start++] = 0;
				} else
					start++;
			}
			
		}
		
		System.out.println(Arrays.toString(array));
	}
	
}
