package com.niksum.java.puzzel;

import java.util.HashMap;
import java.util.Map;

public class DuplicateIn2DimArray {
	public static void main(String[] args) {
		int [][] my2DArray = {{1,2,3,4}, {4,44,5,3}, {3,11,2,32},{4,11,1,32}};
		Map<Integer, Integer> duplicateMap = new HashMap<>();		
		for (int row = 0; row < my2DArray.length; row++) {
			for (int col = 0; col < my2DArray[row].length; col++) {
				if(duplicateMap.containsKey(my2DArray[row][col]))
					duplicateMap.put(my2DArray[row][col], duplicateMap.get(my2DArray[row][col])+1);
				else
					duplicateMap.put(my2DArray[row][col], 1);
			}
		}
		
		duplicateMap.forEach((key,value) -> {
			System.out.println("Key : "+ key + " value : "+ value);
		});
	}
}
