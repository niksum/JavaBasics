package com.niksum.java.datastructure.searching;

import java.util.ArrayList;
import java.util.List;

public class SearchStyles {
	public static void main(String[] args) {
//		linearSearch();
//		binarySearch();
//		interpolationSearch();
		jumpSearch();
	}
	
	// It is used for sorted array an having a complexity of O (underroot of N). Better then linear search
	private static void jumpSearch(){
		int arr[] = { 0, 1, 1, 2, 3, 5, 8, 13, 21,
                34, 55, 89, 144, 233, 377, 610};
		int search = 610;
		int arrLength = arr.length;
		int jumpFactor = (int)Math.floor(Math.sqrt(arrLength));
		int currentJump = jumpFactor;
		int startPos = 0;
		int counter = 0;
		
		while(arr[Math.min(currentJump, arrLength)-1] < search){
			startPos = currentJump;
			currentJump += jumpFactor;
			counter++;
			if(startPos >= arrLength){
				System.out.println("Did not find element in array. Reached end");
				return;
			}
		}
		
		while(arr[startPos] < search){
			startPos++;
			counter++;
			if(startPos == Math.min(currentJump, arrLength)){
				System.out.println("Did not find element in array. In block "+startPos + " , current jump " + currentJump + " ,  counter "+ counter);
				return;
			}
		}
		if(arr[startPos] == search){
			System.out.println("Got the element in array at position "+startPos + ",  counter "+ counter );
			return;
		}
		
		System.out.println("Did not find element  In block "+startPos + " , current jump " + currentJump +",  counter "+ counter);
	}
	

	// very good in case we have ordered list and distributed equally.. it gives
	// a complexity of O (log (log n))
	private static void interpolationSearch() {
		List<Integer> intList = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			// intList.add(i+(i*2));
			intList.add(i + (i * 3));
		}
		int search = 96;
		int counter = 0;
		int low = 0;
		int high = intList.size() - 1;
		try {
			while (low <= high && search >= intList.get(low) && search <= intList.get(high)) {
				counter++;
				int position = low
						+ (((high - low) * (search - intList.get(low))) / (intList.get(high) - intList.get(low)));
				if (intList.get(position) == search) {
					System.out.println("Find element at position " + position + " in counter " + counter);
					return;
				}
				if (intList.get(position) < search)
					low = position + 1;
				else
					high = position - 1;
			}
		} catch (Exception e) {
			System.err.println("issue \n" + e.getMessage());
			e.printStackTrace();
			System.out.println("low " + low + "  high " + high + " counter " + counter);
		}
		System.out.println("Did not find element ");
	}

	// good if we have ordered list. it has complexity of O(Log n) time
	private static void binarySearch() {
		List<Integer> intList = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			intList.add(i + (i * 3));
		}
		int searchInt = 96;
		int counter = 0;
		binarySearchAlgo(intList, 0, intList.size() - 1, searchInt, counter);
	}

	private static void binarySearchAlgo(List<Integer> input, int start, int end, int search, int counter) {
		counter++;
		if (start > end) {
			System.out.println("Element is not present in list");
			return;
		}
		int position = (start + end) / 2;
		if (input.get(position) == search) {
			System.out.println("Element is present at position " + position + " .. counter is " + counter);
		} else if (input.get(position) > search) {
			binarySearchAlgo(input, start, position - 1, search, counter);
		} else if (input.get(position) < search) {
			binarySearchAlgo(input, position + 1, end, search, counter);
		} else {
			System.out.println("Element is not present");
		}
	}

	// not a good approach it has a complexity of O(n) time
	private static void linearSearch() {
		List<Integer> intList = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			intList.add(i);
		}

		int searchInt = 99;
		int counter = 0;
		for (Integer integer : intList) {
			counter++;
			if (integer == searchInt) {
				System.out.println("Find element at position " + counter);
				return;
			}
		}
		System.out.println("Did not find element in list");
	}
}
