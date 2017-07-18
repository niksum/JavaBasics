package com.niksum.java.puzzel;

class LocalList{
	public static class Node{
		public String _data;
		public Node _next;
		
		public Node(String data){
			_data = data;
			_next = null;
		}
		
		public void displayLink(){
			System.out.println("Data is " + _data);
		}
	}
	
	public Node first, last;
	
	public LocalList(){
		first = null;
		last = null;
	}
	
	public void addData(String data){
		Node newNode = new Node(data);
		if(first == null)
			first = last = newNode;
		else
			last._next = newNode;
		
		last = newNode;
		newNode._next = first;
	}
	
	public Node find(String data){
		Node current = first;
		while(current._data != data){
			current = current._next;
		}
		return current;
	}
	
	public Node delete(String data){
		Node current = first;
		while(current._data != data){
			current = current._next;
		}
		
		Node removed = current;
		current = current._next;
		return removed;
	}
}

public class CircularListExample {
	public static void main(String[] args) {
		LocalList myList = new LocalList();
		myList.addData("Nikhil");
		myList.addData("Kumar");
		myList.addData("Summi");
		myList.addData("Ku");
		
		System.out.println(myList.find("Ku")._data);
		System.out.println(myList.delete("Ku")._data);
		System.out.println();
	}
}
