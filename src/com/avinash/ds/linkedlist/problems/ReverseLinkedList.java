package com.avinash.ds.linkedlist.problems;

public class ReverseLinkedList {
	
	Node head;
	
	public static void main(String[] args) {
		
		ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
		
		reverseLinkedList.head = new Node(1);
		reverseLinkedList.head.next = new Node(2);
		reverseLinkedList.head.next.next = new Node(3);
		reverseLinkedList.head.next.next.next = new Node(7);
		reverseLinkedList.head.next.next.next.next = new Node(4);
		reverseLinkedList.head.next.next.next.next.next = new Node(5);
		
		System.out.println("Before reversing");
		printLL(reverseLinkedList.head);
		
		reverseLinkedList.head = reverseLL(reverseLinkedList.head);
		
		System.out.println("After reversing");
		printLL(reverseLinkedList.head);

	}

	private static Node reverseLL(Node current) {
		
		Node prev = null;
		Node temp = null;
		
		 
		
		while(current!=null) {
			
			temp = current.next;
			current.next = prev;
			prev = current;
			
			current = temp;
		}
		
		return prev;
		
	}

	private static void printLL(Node temp) {
		
		while(temp!=null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		
	}

	 

}
