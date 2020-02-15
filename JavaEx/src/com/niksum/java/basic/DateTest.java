package com.niksum.java.basic;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DateTest {
public static void main(String[] args) {
	Date date = new Date();
	Date date2 = new Date(2019, 05, 21);
	System.out.println(date);
	System.out.println(date2);
	
	String dateFormat = "yyyy-MM-dd";
	DateFormat df = new SimpleDateFormat(dateFormat);
	String date3 = df.format(new Date());
	System.out.println(date3);
	Date date4 =null;
	try {
		date4 = df.parse("1984-02-24");
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	Stream streamOfLetters = Stream.of("abc", "cde", "efg", "jkd", "res"); 
	ArrayList list = new ArrayList<>(); 
	streamOfLetters.forEach(list::add);
	System.out.println(list);
	
	String[] myArray = {"a","bc","dd","ee","ddd","adfda","b"};
	List myList = Arrays.stream(myArray).collect(Collectors.toList());
	System.out.println(myList);
	
	
	Stream streamOfNumbers2 = Stream.of("one", "two", "three", "four", "five"); 
	ArrayList myList2 = new ArrayList<>(); 

	
}

}
