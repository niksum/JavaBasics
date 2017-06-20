package com.niksum.java;

public class Test1 {
	static void update(int num){num=11;}
	static void update(int [] nums){nums[0]=11;}
	
	public static void main(String[] args) {
		int num=0; 
		update(num);
		int []nums = {1,3,5,7};
		update(nums);
		System.out.println(num);
		for (int i : nums) {
			System.out.println(i + ", ");
		}
	}
}
