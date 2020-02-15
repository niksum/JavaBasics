package com.niksum.java;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Test3 {
	public static void main(String[] args) {

		//printMatrixDiagonalDiff();
		//printPercentage();
		//staircase();
		//printMinAndMax();
		//candel();
		//timeFormetConvertor();
		//teacherGrading();
		//countApplieAndOranges();
		//System.out.println(kangarro());
		
		//sortAndReverseIntArr();
		//reverseIntArr();
		
		//hourGlass();
		
		//dynamicArray();
		//leftRotation();
		
		//frequencyOfWord();
		arrayManipulation();
		
		//arrayPair();
	}
	
	private static void arrayPair(){
		int[] arr = {1259 ,7119 ,6806 ,8924 ,8114 ,3797 ,6788 ,3735, 6695 ,7189, 5028, 2092, 
				8103 ,2206 ,3708 ,7873 ,7572 ,6687 ,8652, 7};//{1,1,2,4,2};
		long result = 0;
		int maxOfArr = 0;
		for (int i = 0; i < arr.length; i++) {
			maxOfArr=maxOfArr>arr[i]?maxOfArr:arr[i];
		}
		for (int i = 1; i <= arr.length; i++) {
			for (int j = i+1; j <= arr.length; j++) {
				boolean pass = arr[i-1]*arr[j-1]<=maxOfArr;
				if(pass){
					result++;
					System.out.println(i +""+ j);
				}
			}
		}
		System.out.println(result);
	}
	
	
	
	
	private static void arrayManipulation(){
		int n=5;
		int [][]queries = {{1, 2, 100},{2, 5, 100},{3, 4, 100}};
		
		long[] input = new long[n];
		
		//Arrays.fill(input, 0);
		
		long maxValue = 0;
//		for (int i = 0; i < queries.length; i++) {
//			if(queries[i].length==3){
//				int startIndex = queries[i][0]-1;
//				startIndex = startIndex<0?0:startIndex;
//				int endIndex = queries[i][1]-1;
//				endIndex = endIndex>n?n:endIndex;
//				for(int j = startIndex; j<= endIndex;j++){
//					input[j]+=queries[i][2];
//					maxValue = input[j]>maxValue?input[j]:maxValue;
//				}
//			}
//		}
		
		for(int i=0;i<queries.length; i++){
			int startIndex = queries[i][0];
			int lastIndex = queries[i][1];
			int sum = queries[i][2];
			input[startIndex-1] +=sum;
			if(lastIndex<n)
				input[lastIndex]-=sum;
		}
		long temp=0;
		for (int i = 0; i < input.length; i++) {
			temp+=input[i];
			if(temp>maxValue)
				maxValue=temp;
		}
		System.out.println(maxValue);
	}
	
	private static void frequencyOfWord(){
		String[] collections = {"ab","bc","ab","cd","de","de","bc","bc","a","bb","dd","dd"};
		Map<String, Integer> wordMap = new HashMap<>();
		for (String string : collections) {
			wordMap.merge(string,1,Integer::sum);
		}
		System.out.println(wordMap);
		System.out.println(wordMap.get("ab"));
	}
	
	private static void leftRotation(){
		int[] input = {3,4,5,2,1};
		int d = 6;
		
		int actualRotation = d>input.length?d%input.length:d==input.length?0:d;
		System.out.println(actualRotation);
		for (int i = 0; i < actualRotation; i++) {
			int temp = input[0];
			int j = 0;
			for  (j = 0; j < input.length -1; j++) 
				input[j] = input[j+1];
			input[j] = temp;
		}
		
		System.out.println();
	}
	
	private static void dynamicArray(){
		int n=2;
		int[][] queries={{1, 0, 5},
				{1 ,1, 7},
				{1 ,0, 3},
				{2 ,1, 0},
				{2 ,1, 1}};
		List<List<Integer>> inLL = new ArrayList<List<Integer>>();
		List<Integer> output = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			inLL.add(new ArrayList<Integer>());
		}
		
		int lastAnswer = 0;
		for (int i = 0; i < queries.length; i++) {
			int seq = ((queries[i][1]^lastAnswer)%n);
			int position = 0;
			//System.out.println(seq);
			
			if(queries[i][0]==1){
				List<Integer> in = inLL.get(seq);
				in.add(queries[i][2]);
			}
			else if(queries[i][0]==2){
				position = queries[i][2]% (inLL.get(seq).size());
				lastAnswer = inLL.get(seq).get(position);
				output.add(lastAnswer);
				System.out.println(lastAnswer);
			}
		}
		int [] outpuArray = output.stream()
				.mapToInt(i -> i).toArray();
		System.out.println(outpuArray);
		
	}
	
	private static void hourGlass(){
		//int[][] arr = {{1,1,1,0,0,0},{0,1,0,0,0,0},{1,1,1,0,0,0},{0,0,2,4,4,0},{0,0,0,2,0,0},{0,0,1,2,4,0}};
		int[][] arr =
		
		{{-1, -1, 0, -9, -2, -2},
		{-2, -1, -6, -8, -2, -5},
		{-1, -1, -1, -2, -3, -4},
		{-1, -9, -2, -4, -4, -5},
		{-7, -3, -3, -2, -9, -9},
		{-1, -3, -1, -2 }};
	 
		for(int i = 0; i< arr.length-2; i++){
			for(int j = 0; j < arr[i].length -2; j++){
				if(arr[i+2].length==arr[i].length ){
					System.out.println(arr[i][j] + " " + arr[i][j+1] + " " + arr[i][j+2]);
					System.out.println("  "+ arr[i+1][j+1]);
					System.out.println(arr[i+2][j] + " " + arr[i+2][j+1] + " " + arr[i+2][j+2] +"\n");
				}
			}
			System.out.println("\n");
		}
		
		
	       int maxSum = 0;
	       
	       for(int i = 0; i< arr.length-2; i++){
	            
				for(int j = 0; j < arr[i].length -2 ; j++){
					if(arr[i+2].length==arr[i].length ){
						
		                int tempSum =0;
		                tempSum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1]
		                    + arr[i+2][j] + arr[i+2][j+1] +  arr[i+2][j+2];
		               
		                if(i==0 && j==0)
		                	maxSum =tempSum;
		                else
		                	maxSum = tempSum>maxSum?tempSum:maxSum;
		               
					}
					
				}
			}
	        
	        System.out.println(maxSum);
	}
	
	private static void reverseIntArr(){
		int [] input = {3,2,5,77,87,11};
		//List<Integer> intArr=Arrays.asList(input);
		//Collections.reverse(Arrays.asList(input));
		//Arrays.stream(input).forEach(System.out::print);	
		
		for (int i = 0; i < input.length/2; i++) {
			int temp = input[i];
			input[i] = input[input.length-i-1];
			input[input.length-i-1] = temp;
		}
		
		System.out.println(Arrays.toString(input));
	}
	
	private static void sortAndReverseIntArr(){
		int[] arr = {3,2,56,22,1,87};
		Integer[] intArr = Arrays.stream(arr)
		.boxed()
		.toArray(Integer [] :: new);
		
		Arrays.sort(intArr, Collections.reverseOrder());
		arr = Arrays.stream(intArr).mapToInt(Integer::intValue).toArray();
		Arrays.stream(intArr).forEach(System.out::print);
		System.out.println(arr);
		
	}
	
	private static String kangarro(){
		int x1=0; int v1=1; int x2=4; int v2=2;
		
		boolean isX1Fast = v1>v2?true:false;
		if(x1==x2)
			return "YES";
		while(x1!=x2){
			x1 +=v1;
			x2 +=v2;
			if(x1==x2)
				return "YES";
			else{
				if((x1>x2)&&isX1Fast)
					return "NO";
				if((x1<x2)&&!isX1Fast)
					return "NO";
			}
		}
		return "YES";
		
	}
	private static void countApplieAndOranges(){
		int s=5;
		int t=10;
		int a=2;
		int b=13;
		int[] apples={-2,3,2,-1,};
		int[] oranges={-1,-3,4,-5};
		
		int numOfApp = apples.length;
		int numOfOran = oranges.length;
		int maxNum = numOfApp>numOfOran?numOfApp:numOfOran;
		
		int resultOfApp = 0; int resultOfOran = 0;
		
		for (int i = 0; i < maxNum; i++) {
			if(i < numOfApp){
				int positionOfApp = (a+apples[i]);
				if(s<=positionOfApp && t>=positionOfApp)
					resultOfApp++;
			}
			if(i < numOfOran){
				int positionOfOrange = (b+oranges[i]);
				if(t>=positionOfOrange && s<=positionOfOrange)
					resultOfOran++;
			}
			
		}
		System.out.println(resultOfApp +" "+ resultOfOran);
	       
	}
	
	private static void teacherGrading(){
		int[] grades = {42,44,38,37,92,55,63};
		
		for (int i = 0; i < grades.length; i++) {
			int grade = grades[i];
			if(grade>=38){
				int modulo = grade%5;  
				if(modulo>=3)
					grades[i] = grade + (5-modulo);
			}
			System.out.println(grades[i]);
		}
		
	}
	private static void timeFormetConvertor(){
		String s = "00:00:00PM";
		DateFormat sdf = new SimpleDateFormat("hh:mm:ssaa");
		DateFormat output = new SimpleDateFormat("HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(s);
			System.out.println(output.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	private static void printMinAndMax(){
		int[] inputArr = {4,2,78,12,6789};
		Arrays.sort(inputArr);
		long minCount=0;
		long maxCount=0;
		for (int i = 0; i < inputArr.length; i++) {
			if(i==0)
				minCount +=inputArr[i];
			else if(i== (inputArr.length -1) )
				maxCount +=inputArr[i];
			else{
				minCount +=inputArr[i];
				maxCount +=inputArr[i];
			}
				
		}
		Integer[] array= Arrays.stream(inputArr)
				.boxed()
				.toArray(Integer[]::new);
		System.out.println(minCount + "  "+ maxCount);
		Arrays.sort(array, Collections.reverseOrder());
		
	}
	
	private static void candel(){
		int[] inputArr = {4,2,78,12,12,4,12};
		 Integer[] array= Arrays.stream(inputArr)
					.boxed()
					.toArray(Integer[]::new);
			
			Arrays.sort(array, Collections.reverseOrder());
			int maxNum = 0 ;
			int counter = 0;
			for (int i = 0; i < array.length; i++) {
				if(i==0){
					maxNum = array[i];
					counter++;
				} else{
					if(maxNum==array[i])
						counter++;
					else
						break;
				}
			}
			System.out.println(counter);
	}
	private static void printMatrixDiagonalDiff(){
		int[][] input = new int[3][3];
		input[0][0] = 11;
		input[0][1] = 2;
		input[0][2] = 4;
		input[1][0] = 4;
		input[1][1] = 5;
		input[1][2] = 6;
		input[2][0] = 10;
		input[2][1] = 8;
		input[2][2] = -12;

		int firstDiagonal = 0;
		int secondDiagonal = 0;
		for (int i = 0; i < input.length; i++) {
			firstDiagonal += input[i][i];
			secondDiagonal += input[i][input[i].length - (i + 1)];
			System.out.println(firstDiagonal);
			System.out.println(secondDiagonal);
		}
		int finalResult = (firstDiagonal + secondDiagonal);
		
		System.out.println(Math.abs(finalResult));
	}

	private static void staircase(){
		int numOfSteps = 4;
		for (int i = 0; i < numOfSteps; i++) {
			for(int j = numOfSteps-1; j>=0; j--){
				if(j>i)
					System.out.print(" ");
				else
					System.out.print("#");
			}
			System.out.println();
		}
	}
	private static void printPercentage() {
		int[] input = {4,2,-1,0,4,5,-98,0,-2};
		int length = input.length;
		double numOfPositive = 0;
		double numOfNegative = 0;
		double numOfZero = 0;
		
		for(int in : input){
			if(in > 0) numOfPositive++;
			else if(in<0) numOfNegative++;
			else numOfZero++;
		}
		
		DecimalFormat df = new DecimalFormat("#.####");
		double positiveP = numOfPositive/length;
		System.out.println(df.format((numOfPositive/length)));
		System.out.println(df.format((numOfNegative/length)));
		System.out.println(df.format((numOfZero/length)));
		
		BigDecimal db = new BigDecimal(Double.toString(positiveP));
		db.setScale(5, RoundingMode.HALF_DOWN);
		System.out.println(db.doubleValue());
	}
}
