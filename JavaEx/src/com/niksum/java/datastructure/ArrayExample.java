package com.niksum.java.datastructure;

import java.time.Duration;
import java.time.Instant;

public class ArrayExample {

	public static void main(String[] args) {
		// System.out.println(">>>>> Search, Insert and Delete Operations in
		// unsorted Array <<<<<");
		// searchInArray();
		// insertInArray();
		// deleteFromArray();

		// System.out.println("\n >>>>> Search, Insert and Delete Operations in
		// sorted Array <<<<<");
		// binarySearch();
//		insertIntoOrderedArray();
		checkTiming();
	}

	public static void insertIntoOrderedArray() {
		int[] input = new int[10];
		input[0] = 4;
		input[1] = 8;
		input[2] = 19;
		input[3] = 48;
		input[4] = 49;
		input[5] = 70;
		int insertElement = 12;
		int currentOccupied = 6;
		for (int ii : input) {
			System.out.print(ii + ", ");
		}
		System.out.println();
		int i;
		for (i = currentOccupied - 1; (i >= 0 && input[i] > insertElement); i--) {
			input[i + 1] = input[i];
		}
		input[i + 1] = insertElement;
		for (int ii : input) {
			System.out.print(ii + ", ");
		}
		
	}

	public static void binarySearch() {
		int[] input = { 3, 5, 7, 9, 11, 13, 23, 45, 78, 999 };
		int search = 03;
		int startIndex = 0;
		int endIndex = input.length - 1;
		System.out.println("Search element Index: " + binarySearch(input, startIndex, endIndex, search));
	}

	private static void checkTiming() {
		int[] input = new int[100000000];
		for (int i = 0; i < input.length; i++) {
			input[i] = i;
		}

		int searchInt = 9999998;
		Instant start = Instant.now();
		sequentialSearch(input, searchInt);
		Instant stop = Instant.now();
		System.out.println("sequential " + Duration.between(start, stop));
		
		
		Instant start2 = Instant.now();
		System.out.println("Search element Index: "+binarySearch(input, 0, input.length - 1, searchInt));
		Instant stop2 = Instant.now();
		System.out.println("binary " + Duration.between(start2, stop2));
	}

	private static void sequentialSearch(int[] input, int element) {
		for (int i = 0; i < input.length; i++) {
			if (input[i] == element) {
				System.out.println("find it");
				return;
			}
		}
		System.out.println("not found ");
		return;
	}

	private static int binarySearch(int[] input, int start, int end, int element) {
		if (end < start)
			return -1;
		int mid = (start + end) / 2;
		if (element == input[mid])
			return mid;
		else if (input[mid] > element)
			return binarySearch(input, start, mid - 1, element);
		return binarySearch(input, mid + 1, end, element);
	}

	public static void deleteFromArray() {
		int[] input = { 1, 4, 6, 8, 2, 54, 23, 87, 0, 90 };
		int deleteElement = 4;
		boolean find = false;
		for (int i = 0; i < input.length; i++) {
			if (input[i] == deleteElement)
				find = true;
			if (find && i != input.length - 1)
				input[i] = input[i + 1];
		}
		System.out.println();
		for (int i : input) {
			System.out.print(i + ", ");
		}
	}

	public static void insertInArray() {
		int[] input = new int[10];
		input[0] = 98;
		input[1] = 8;
		input[2] = 198;
		input[3] = 948;
		input[4] = 45;
		input[5] = 0;
		int totalElementFilled = 6;
		System.out.println("Inserting element into array at next available location");
		int insertElement = 876;
		input[totalElementFilled] = insertElement;
		for (int i : input) {
			System.out.print(i + "\t ");
		}
	}

	public static void searchInArray() {
		int[] input = { 1, 4, 6, 8, 2, 54, 23, 87, 0, 90 };
		System.out.println("Searching in Array need to be done in a sequentail manner as it is unsorted array");
		int find = 8;
		boolean present = false;
		for (int i : input) {
			if (i == find) {
				System.out.println(find + " is present in array");
				present = true;
			}

		}
		if (!present)
			System.out.println(find + " is not present in array");

		Object[] objArr = new Object[5];
		objArr[0] = new Integer(5);
		objArr[1] = new Double(5.5);
		objArr[2] = new String("Nikhil");
		objArr[3] = new Character('d');

		for (Object object : objArr) {
			System.out.println("Object Array elements " + ((object != null) ? object.toString() : " object is null"));

		}
	}
}
