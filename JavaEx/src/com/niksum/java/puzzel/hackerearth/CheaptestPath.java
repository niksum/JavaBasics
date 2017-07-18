package com.niksum.java.puzzel.hackerearth;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class CheaptestPath {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numOfTestCase = Integer.parseInt(scanner.nextLine());
		if(numOfTestCase<1 || numOfTestCase>5){
			System.out.println("Number of test cases is not as per expectation");
			return;
		}
		
		
		System.out.println("Number of test cases # "+ numOfTestCase);
		for (int i = 0; i < numOfTestCase; i++) {
			int numOfCheckPoint = Integer.parseInt(scanner.nextLine());
			
			System.out.println("Number of check points are "+ numOfCheckPoint +" for test case # "+i);
			
			
			long[] costPerLtrOfCPArr = Stream.of(scanner.nextLine().split(" " ))
					.mapToLong(Long::parseLong)
					.toArray();
			
			System.out.println("Cost per Liter for check points are " + Arrays.toString(costPerLtrOfCPArr));
								
			long[] reqPetForNextCPArr = Stream.of(scanner.nextLine().split(" "))
					.mapToLong(Long::parseLong)
					.toArray();
			System.out.println("Requred petrol to reach next check point array " + Arrays.toString(reqPetForNextCPArr));
			
			processData(numOfCheckPoint, costPerLtrOfCPArr, reqPetForNextCPArr);
		}
		
		scanner.close();
	
	}
	
	private static void processData(int cp, long[] costPerLtr, long[] reqPet){
		int startCP = 1;
		int endCP = cp-1;
		long totalCost = 0;
		long minCostOfPet = costPerLtr[0];
		long totalDisForCurrCost = reqPet[0];
		while(startCP <= endCP){
			if(minCostOfPet > costPerLtr[startCP]){
				totalCost = totalCost + (minCostOfPet * totalDisForCurrCost);
				minCostOfPet = costPerLtr[startCP];
				totalDisForCurrCost = reqPet[startCP];
			} else{
				totalDisForCurrCost = totalDisForCurrCost + reqPet[startCP];
			} if(startCP == endCP){
				totalCost = totalCost + (minCostOfPet * totalDisForCurrCost);
			}
			
			startCP ++;
		}
		
		System.out.println(totalCost);
	}
}
