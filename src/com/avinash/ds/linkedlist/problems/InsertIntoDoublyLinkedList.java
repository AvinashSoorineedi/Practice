package com.avinash.ds.linkedlist.problems;

public class InsertIntoDoublyLinkedList {

	public static void main(String[] args) {

		sortedInsert(new DoublyLinkedListNode(), 1);

	}

	static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {

		DoublyLinkedListNode temp = head;
		while (temp != null) {
			if (temp.data < data) {
				temp = temp.next;
			} else {
				DoublyLinkedListNode doublyLinkedListNode = new DoublyLinkedListNode();
				
				temp.prev.next = doublyLinkedListNode;
				doublyLinkedListNode.next = temp;
				temp.prev = doublyLinkedListNode;
			}
		}
		return temp;
	}

}

class DoublyLinkedListNode {
	int data;
	DoublyLinkedListNode next;
	DoublyLinkedListNode prev;
}
