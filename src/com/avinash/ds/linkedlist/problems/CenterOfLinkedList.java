package com.avinash.ds.linkedlist.problems;

import com.avinash.ds.linkedlist.MyLinkedList;
import com.avinash.ds.linkedlist.Node;

public class CenterOfLinkedList {

	public static void main(String[] args) {
		
		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.addFirst("A");
		myLinkedList.addFirst("B");
		myLinkedList.addFirst("C");
		myLinkedList.addFirst("D");
		myLinkedList.addFirst("E");
		myLinkedList.addFirst("F");
		myLinkedList.addFirst("G");
		myLinkedList.addFirst("H");
		
		Node firstPointer = myLinkedList.getHead();
		Node secondPointer = myLinkedList.getHead();
		
		while(secondPointer!=null && secondPointer.getNext()!=null) {
			firstPointer = firstPointer.getNext();
			secondPointer = secondPointer.getNext().getNext();
		}
		
		System.out.println("Center of element is "+firstPointer.getData());

	}

}
