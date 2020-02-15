package com.niksum.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MergingTwoList {
	   static class SinglyLinkedListNode {
	        public int data;
	        public SinglyLinkedListNode next;

	        public SinglyLinkedListNode(int nodeData) {
	            this.data = nodeData;
	            this.next = null;
	        }
	    }

	    static class SinglyLinkedList {
	        public SinglyLinkedListNode head;
	        public SinglyLinkedListNode tail;

	        public SinglyLinkedList() {
	            this.head = null;
	            this.tail = null;
	        }

	        public void insertNode(int nodeData) {
	            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

	            if (this.head == null) {
	                this.head = node;
	            } else {
	                this.tail.next = node;
	            }

	            this.tail = node;
	        }
	    }

	    public static void printSinglyLinkedList(SinglyLinkedListNode node) throws IOException {
	        while (node != null) {
	            System.out.println(node.data);

	            node = node.next;

	        }
	    }
	    
	    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
	    	SinglyLinkedList mergedList = new SinglyLinkedList();
	    	if(head1==null)
	    		return head2;
	    	else if(head2==null)
	    		return head1;
	    	
	    	while(head1!=null || head2!=null){
	    		int tempData = 0;
	    		if(head1!=null && head2!=null){
		    		if(head1.data>head2.data){
		    			tempData=head2.data;
		    			head2=head2.next;
		    		}
		    		else {
		    			tempData=head1.data;
		    			head1= head1.next;
		    		}
	    		} else if(head1==null){
	    			tempData=head2.data;
	    			head2= head2.next;
	    		} else if(head2==null){
	    			tempData=head1.data;
	    			head1= head1.next;
	    		}
	    		
	    		mergedList.insertNode(tempData); 
	    		
	    	}
	    	
	    	return mergedList.head;

	    }

	    static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
	    	if(head==null)
	    		return null;
	    	Map<Integer,SinglyLinkedListNode> sortedNodeMap = new TreeMap<>();
	    	while(head!=null){
	    		sortedNodeMap.putIfAbsent(head.data, head);
	    		head=head.next;
	    	}
	    	
	    	SinglyLinkedList outputNodeList = new SinglyLinkedList();
	    	for (Map.Entry<Integer, SinglyLinkedListNode> entry : sortedNodeMap.entrySet()) 
	    		outputNodeList.insertNode(entry.getKey());
	    	return outputNodeList.head;
	    }
	    
	    static int getNode(SinglyLinkedListNode head, int positionFromTail) {
	    	SinglyLinkedListNode mainPointer= head;
	    	SinglyLinkedListNode referencePointer=head;
	    	int counter=0;
	    	if(head!=null){
	    		while(counter<=positionFromTail){
	    			if(referencePointer==null)
	    				return -1;
	    			referencePointer=referencePointer.next;
	    			counter++;
	    		}
	    		while(referencePointer!=null){
	    			referencePointer=referencePointer.next;
	    			mainPointer=mainPointer.next;
	    		}
	    	}
	    	
	    	return mainPointer.data;
	    }
	   
	    static boolean hasCycle(SinglyLinkedListNode head) {
	    	SinglyLinkedListNode slow = head;
	    	SinglyLinkedListNode fast = head;
	    	while(fast!=null && fast.next!=null){
	    		slow = slow.next;
	    		fast = fast.next.next;
	    		if(slow==fast)
	    			return true;
	    	}
	    	return false;
	    }
	    
	    static boolean hasDuplicate(SinglyLinkedListNode head) {
	    	 SinglyLinkedListNode temp = head;
	            if(temp.next==null)
	                return false;
		    	
	            List<Integer> list = new ArrayList<>();
	            while(temp.next!=null){
	                if(list.contains(temp.data))
	                    return true;
	                else list.add(temp.data);
	                temp = temp.next;
	            }
		    	
		    	return false;

	    }
	    public static void main(String[] args) throws IOException {
	    	
	    	System.out.println("Test of has cyclic");
	    	SinglyLinkedList cyclicInput = new SinglyLinkedList();
	    	cyclicInput.insertNode(1);
	    	cyclicInput.insertNode(1);
	    	cyclicInput.insertNode(3);
	       	cyclicInput.insertNode(1);
	    	cyclicInput.insertNode(2);
	    	cyclicInput.insertNode(3);
	    	System.out.println(hasDuplicate(cyclicInput.head));
	    	
	    	SinglyLinkedList list1 = new SinglyLinkedList();
	    	list1.insertNode(1);
	    	list1.insertNode(3);
	    	list1.insertNode(4);
	    	
	    	SinglyLinkedList list2 = new SinglyLinkedList();
	    	list2.insertNode(3);
	    	list2.insertNode(4);
	    	list2.insertNode(7);
	    	
	    	printSinglyLinkedList(list1.head);
	    	
	    	printSinglyLinkedList(mergeLists(list1.head,list2.head));
	    	
	    	SinglyLinkedList inputList = new SinglyLinkedList();
	    	inputList.insertNode(3);
	    	inputList.insertNode(5);
	    	inputList.insertNode(17);
	    	inputList.insertNode(44);
	    	inputList.insertNode(30);
	    	inputList.insertNode(378);
	    	
	    	System.out.println(getNode(inputList.head,0));
	    	
	    	System.out.println("Removing duplicater and sorting");
	    	SinglyLinkedList input = new SinglyLinkedList();
	    	input.insertNode(1);
	    	input.insertNode(5);
	    	input.insertNode(1);
	    	input.insertNode(3);
	    	input.insertNode(4);
	    	input.insertNode(4);
	    	input.insertNode(2);
	    	input.insertNode(6);
	    	input.insertNode(4);
	    	
	    	printSinglyLinkedList(removeDuplicates(input.head));
	    }
}
