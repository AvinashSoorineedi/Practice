package com.avinash.ds.linkedlist.problems;

import javax.sound.midi.Soundbank;

public class RemoveDuplicateInSortedLinkedList {

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

	private void printList(Node head) {
		if (head == null) {
			System.out.println("No Elements to display");
		} else {
			Node temp = head;
			while (temp != null) {
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
		}
	}

	public static void main(String[] args) {

		RemoveDuplicateInSortedLinkedList lList = new RemoveDuplicateInSortedLinkedList();

		lList.addFirst(5);
		lList.addFirst(10);
		lList.addFirst(10);
		lList.addFirst(10);
		lList.addFirst(20);
		lList.addFirst(20);
		lList.addFirst(30);
		lList.addFirst(30);

		System.out.println("Before Deleting :::::::");
		lList.printList(lList.head);

		lList.removeAdjacentDuplicates(lList);

		System.out.println("After Deleting :::::::");
		lList.printList(lList.head);

	}

	private void removeAdjacentDuplicates(RemoveDuplicateInSortedLinkedList lList) {

		if (lList.head == null) {
			System.out.println("No Elements to remove");
		} else if (lList.head.next == null) {
			if (lList.head == lList.head.next) {
				System.out.println(lList.head.next);
				lList.head.next = null;
			}
		} else if (lList.head.next != null) {
			Node first = lList.head;
			Node second = lList.head.next;

			while (second != null) {
				if (first.data == second.data) {

					Node temp1 = second;

					second = second.next;
					first.next = second;
					temp1.next = null;

				} else {
					first = first.next;
					second = second.next;
				}
			}
		}

	}

	private void removeElement(RemoveDuplicateInSortedLinkedList lList, Node nodeToDelete, Node prevNode) {

		if (prevNode == null) {
			prevNode = nodeToDelete.next;
			lList.head = prevNode;
			nodeToDelete.next = null;
		} else {
			prevNode = nodeToDelete.next;
			nodeToDelete.next = null;
		}

	}

}
