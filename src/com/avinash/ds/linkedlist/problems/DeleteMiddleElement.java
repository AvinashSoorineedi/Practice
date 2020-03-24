package com.avinash.ds.linkedlist.problems;

public class DeleteMiddleElement {

	private Node head;

	public class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private void addFirst(int data) {
		if (head == null) {
			head = new Node(data);
		} else {
			Node temp = new Node(data);
			temp.next = head;
			head = temp;
		}
	}

	private void deleteMiddleElement(DeleteMiddleElement lList, Node head) {
		if (head == null) {
			System.out.println("No Elements to delete");
		} else {
			Node first = lList.head;
			Node second = lList.head;

			while (second != null && second.next != null) {
				second = second.next.next;
				first = first.next;
			}

			Node deletedNode = deleteNode(lList, first.data);
			System.out.println("Deleted Node is "+deletedNode.data);
		}

	}

	private Node deleteNode(DeleteMiddleElement lList, int data) {
		Node deleteNode = lList.head.next;
		Node temp = lList.head;
		while (deleteNode != null) {
			if (deleteNode.data == data) {
					temp.next = deleteNode.next;
					deleteNode.next = null;
					break;
			}
			temp = deleteNode;
			deleteNode = deleteNode.next;
		}
		return deleteNode;
	}

	public static void main(String[] args) {
		DeleteMiddleElement lList = new DeleteMiddleElement();
		lList.addFirst(10);
		lList.addFirst(80);
		lList.addFirst(90);
		lList.addFirst(40);
		lList.addFirst(50);
		lList.addFirst(60);
		lList.addFirst(70);
		lList.addFirst(100);
		lList.addFirst(110);
		
		System.out.println("Before deleting::::::");
		lList.printList(lList.head);

		lList.deleteMiddleElement(lList, lList.head);
		
		System.out.println("After deleting::::::");
		lList.printList(lList.head);
	}
	
	public void printList(Node head) {
		if (head == null) {
			System.out.println("No Elements available");
		} else {
			while (head != null) {
				System.out.print(head.data + " ");
				head = head.next;
			}
		}
	}


}
