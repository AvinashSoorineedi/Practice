package com.avinash.ds.linkedlist;

public class LinkedListDemo {

	public static void main(String[] args) {
		
		MyLinkedList myLinkedList = new MyLinkedList();
		
		myLinkedList.addFirst("abc");
		
		System.out.println("The first element is "+myLinkedList.getFirst());
		
		MyLinkedList myLinkedList2 = new MyLinkedList();
		
		myLinkedList2.addFirst("xyz");
		
		System.out.println("The first element is "+myLinkedList2.getFirst());
		
		myLinkedList.addFirst("de");
		
		System.out.println("The first element is "+myLinkedList.getFirst());
		
		System.out.println("The second element is "+myLinkedList.getElementWithIndex(1));
		
		

		System.out.println("The first element LENGTH is "+myLinkedList.getLength());
	}

}
