package com.niksum.java.feature8;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Person {

	private String name;
	private int age;

	public Person(String name, int age) {
		this.setName(name);
		this.setAge(age);
	}

	@Override
	public String toString() {
		return "Person [getName()=" + getName() + ", getAge()=" + getAge() + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}

public class StreamExample {
	public static void main(String[] args) {
//		inputIntoArray();
//		stringArrayFilter();
//		steamOnObjectList();
//		intArraysOperations();
		
		processingOnStream();
	}
	
	private static void processingOnStream(){
		Stream.of("d1","e2","e","5t","324")
		.filter(s -> {
			System.err.println("Filters : "+s);
			return true;
		})
		.forEach(k -> System.err.println("For each : "+k));
		
		System.out.println("\n \n");
		
		Stream.of("d1","e2","e","5t","324")
		.map(s -> {
			System.err.println("Filters : "+s);
			return s.toUpperCase();
		})
		.anyMatch(s -> {System.out.println("Any match "+s);
		return s.startsWith("E");
		});
	}

	private static void intArraysOperations() {

		// Stream function to filter array and printing all elements
		Arrays.stream(new int[] { 56, 4, 78, 333, 890, 1, 2, 32, 12, 6666 }).filter(n -> n > 32)
				.forEach(System.out::println);

		// Stream function to filter array and printing the sum
		System.out.println("\n Sum of filtered data "
				+ Arrays.stream(new int[] { 56, 4, 78, 333, 890, 1, 2, 32, 12, 6666 }).filter(n -> n > 32).sum());

		Arrays.stream(new int[] { 56, 4, 78, 333, 890, 1, 2, 32, 12, 6666 }).filter(n -> n > 32).average()
				.ifPresent(System.out::println);

		System.out.println("\n count of filtered data "
				+ Arrays.stream(new int[] { 56, 4, 78, 333, 890, 1, 2, 32, 12, 6666 }).filter(n -> n > 32).count());
	}

	private static void steamOnObjectList() {
		List<Person> perList = Arrays.asList(new Person("ABC", 45), new Person("KBC", 75), new Person("RCS", 55),
				new Person("EREC", 40));

		Person result = perList.stream().filter(x -> "RCS".equals(x.getName())).findAny().orElse(null);
		System.out.println(result.toString());

		System.out.println(perList.stream().filter(x -> 70 < x.getAge()).findAny().orElse(null));
		System.out.println(perList.stream().filter(x -> 70 == x.getAge()).findAny().orElse(null));

		System.out.println(
				perList.stream().filter((x) -> "KBC".equals(x.getName()) && 70 < x.getAge()).findAny().orElse(null));

		System.out.println("\n Give first result satisfying the filter "
				+ perList.stream().filter(x -> 45 <= x.getAge()).map(Person::getName).findAny().orElse(null));

		System.out.println("\n Return the list that satisfying the filter "
				+ perList.stream().filter(x -> 45 <= x.getAge()).map(Person::getName).collect(Collectors.toList()));

		System.out.println("\n Return the count of Person that satisfying the filter "
				+ perList.stream().filter(x -> 45 <= x.getAge()).map(Person::getAge).count());

		System.out.println("\n Return the Age of Persons in ordered that satisfying the filter " + perList.stream()
				.filter(x -> 45 <= x.getAge()).map(Person::getAge).sorted().collect(Collectors.toList()));

	}

	private static void stringArrayFilter() {
		List<String> input = Arrays.asList("ABC", "DEF", "GHI", "JKL", "MNO");
		List<String> output = input.stream().filter(in -> !"ABC".equals(in)).collect(Collectors.toList());

		output.forEach(System.out::println);
	}

	private static void inputIntoArray() {
		Scanner scan = new Scanner(System.in);
		// Here below I read line from System.in and converting it to Stream
		// using split
		// then I mapped it into Integer
		// after that applied filter for operations
		// converted it to Array again
		int[] inputStr = Stream.of(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).filter(i -> i > 10)
				.toArray();

		Arrays.stream(inputStr).forEach(System.out::println);
	}
}
