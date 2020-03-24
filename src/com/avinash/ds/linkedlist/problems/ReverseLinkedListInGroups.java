package com.avinash.ds.linkedlist.problems;

import java.util.Stack;

public class ReverseLinkedListInGroups {

	private Node head;

	public static void main(String[] args) {

		ReverseLinkedListInGroups linkedListInGroups = new ReverseLinkedListInGroups();
		linkedListInGroups.head = new Node(1);
		linkedListInGroups.head.next = new Node(2);
		linkedListInGroups.head.next.next = new Node(3);
		linkedListInGroups.head.next.next.next = new Node(4);
		linkedListInGroups.head.next.next.next.next = new Node(5);
		linkedListInGroups.head.next.next.next.next.next = new Node(6);
		linkedListInGroups.head.next.next.next.next.next.next = new Node(7);
		linkedListInGroups.head.next.next.next.next.next.next.next = new Node(8);

		System.out.println("The Input List is");
		linkedListInGroups.printLL(linkedListInGroups.head);

		System.out.println();
		int groupSize = 3;
		System.out.println("The List after reversing in groups of k=" + groupSize);
		Node root = reverseListInGroups(linkedListInGroups.head, groupSize);
		linkedListInGroups.printLL(root);

	}

	private static Node reverseListInGroups(Node head, int groupSize) {
		
		Node temp = head;
		Node ref = null;
		Node root = head;
		Node start = head;
		Node end = null;
		Stack<Node> stack = new Stack<Node>();
		int count = 0;
		while(temp!=null) {
			stack.push(temp);
			count++;
			
			if(count%groupSize==0) {
				ref = stack.pop();
				end = ref.next;
				if(start == root) {
					root = ref; 
				} else {
					start.next = ref;
				}
				while(!stack.isEmpty()) {
					ref.next = stack.pop();
					ref = ref.next;
				}
				start = ref;
				ref.next = end;
				temp = end;
				
				continue;
			}
			temp = temp.next;
		}
		
		//process last elements below the group range
		if(!stack.isEmpty()) {
			ref = stack.pop();
			if(start == root) {
				root = ref; 
			} else {
				start.next = ref;
			}
			ref.next = stack.pop();
			ref = ref.next;
		}
		ref.next = null;
		
		return root;
	}

	private void printLL(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

}

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}
