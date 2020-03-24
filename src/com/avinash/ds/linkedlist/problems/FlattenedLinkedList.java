package com.avinash.ds.linkedlist.problems;

public class FlattenedLinkedList {

	Node head;
	
	class Node {
		int data;
		Node down, right;

		Node(int data) {
			this.data = data;
			down = null;
			right = null;
		}
	}
	
	private Node insert(Node headRef, int data) {
		
		Node newNode = new Node(data);
		newNode.down = headRef;
		headRef = newNode;
		
		return headRef;
	}
	
	private void printList(Node root) {
		Node temp = root;
		while(temp!=null) {
			System.out.println(temp.data+ " ");
			temp = temp.down;
		}
	}
	
	private Node flatten(Node root) {
	
		if(root == null || root.right==null) {
			return root;
		}
		
		root.right = flatten(root.right);
		
		root = merge(root, root.right);
		
		return root;
		
	}
	
	
	private Node merge(Node root, Node right) {
		
		if(root == null) {
			return right;
		}
		
		if(right == null) {
			return root;
		}
		
		Node result = null;
		
		if(root.data<right.data) {
			result = root;
			result.down = merge(root.down, right);
		}else if(root.data > right.data) {
			result = right;
			result.down = merge(right.down, root);
		}
		
		return result;
	}

	public static void main(String args[]) {
		FlattenedLinkedList flattenedLinkedList = new FlattenedLinkedList();
		
		flattenedLinkedList.head = flattenedLinkedList.insert(flattenedLinkedList.head, 30);
		flattenedLinkedList.head = flattenedLinkedList.insert(flattenedLinkedList.head, 8);
		flattenedLinkedList.head = flattenedLinkedList.insert(flattenedLinkedList.head, 7);
		flattenedLinkedList.head = flattenedLinkedList.insert(flattenedLinkedList.head, 5);
		
		flattenedLinkedList.head.right = flattenedLinkedList.insert(flattenedLinkedList.head.right, 20);
		flattenedLinkedList.head.right = flattenedLinkedList.insert(flattenedLinkedList.head.right, 10);
	
		flattenedLinkedList.head.right.right = flattenedLinkedList.insert(flattenedLinkedList.head.right.right, 50);
		flattenedLinkedList.head.right.right = flattenedLinkedList.insert(flattenedLinkedList.head.right.right, 22);
		flattenedLinkedList.head.right.right = flattenedLinkedList.insert(flattenedLinkedList.head.right.right, 19);

		flattenedLinkedList.head.right.right.right = flattenedLinkedList.insert(flattenedLinkedList.head.right.right.right, 45);
		flattenedLinkedList.head.right.right.right = flattenedLinkedList.insert(flattenedLinkedList.head.right.right.right, 40);
		flattenedLinkedList.head.right.right.right = flattenedLinkedList.insert(flattenedLinkedList.head.right.right.right, 35);
		flattenedLinkedList.head.right.right.right = flattenedLinkedList.insert(flattenedLinkedList.head.right.right.right, 28);
		
		//flattenedLinkedList.printList(flattenedLinkedList.head);
		
		Node root = flattenedLinkedList.flatten(flattenedLinkedList.head);
		
		flattenedLinkedList.printList(root);
	}
}
