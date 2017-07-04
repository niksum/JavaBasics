package com.niksum.java.puzzel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.print.attribute.IntegerSyntax;

public class TestArrayInput {
	public static void main(String[] args) throws Exception {
		
		comparison();

	}
	public static void comparison(){
		Integer A = new Integer(1);
		int B =1;
		Integer C  = new Integer(1);
		Integer D = B;
		System.out.println(A==B);
		System.out.println(C==B);
		System.out.println(A==C);
		System.out.println(D==B);
		System.out.println(D==C);
	}
	public static void usingStrigBuffer() throws Exception {
		 BufferedReader br = new BufferedReader(new
		 InputStreamReader(System.in));
		 String line = br.readLine();
		 int N = Integer.parseInt(line);
		
		
		 String aArrayValues = br.readLine();
		 String bArrayValues = br.readLine();
		 if(aArrayValues == null || aArrayValues.isEmpty() || bArrayValues ==
		 null || bArrayValues.isEmpty()){
		 System.out.println("No data found for Array");
		 return;
		 }
		 int A[] = new int[N];
		 int B[] = new int[N];
		
		 String[] aArrVal = aArrayValues.split(" ");
		 String[] bArrVal = bArrayValues.split(" ");
		
		 if(aArrVal.length < N || bArrVal.length < N){
		 System.out.println("Input data is less then expected");
		 return;
		 }
		 int C[] = new int[N];
		
		 for (int i = 0; i < N; i++) {
		 A[i] = Integer.parseInt(aArrVal[i]);
		 B[i] = Integer.parseInt(bArrVal[i]);
		 C[i] = A[i] + B[i];
		 System.out.print(C[i] + " ");
		 }
	}
	
	public static void usingSccan() throws Exception {

		Scanner scan = new Scanner(System.in);
		int N = Integer.parseInt(scan.nextLine());
		int[] A = Stream.of(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int[] B = Stream.of(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int[] C = new int[N];
		IntStream.range(0, N).forEach(i -> C[i] = A[i] + B[i]);

		for (int j = 0; j < C.length; j++) {
			System.out.print(C[j] + " ");
		}

	}
}
