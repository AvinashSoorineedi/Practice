package com.avinash.ds.linkedlist.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.avinash.sorting.SortingUtil;

public class SumEqualsZero {

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node head;

	public void insertAtStart(int data) {
		insertAtStart(new Node(data));
	}

	private void insertAtStart(Node node) {
		if (head == null) {
			head = node;
		} else {
			node.next = head;
			head = node;
		}
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

	private Node removeElement(SumEqualsZero lList, int elem) {

		if (lList.head.data == elem) {
			Node temp = lList.head;
			lList.head = lList.head.next;
			temp.next = null;

		}

		if (lList.head != null && lList.head.next != null) {
			Node first = lList.head.next;
			Node prev = lList.head;

			while (first != null) {
				if (first.data == elem) {
					prev.next = first.next;
					first.next = null;
				}
				prev = first;
				first = first.next;

			}
		}

		return lList.head;
	}

	private void removeZeroSumElementsConsecutive(SumEqualsZero lList, Node head) {
		if (lList.head == null || lList.head.next == null) {
			System.out.println("No Elements in the list");
		}

		Node first = lList.head;
		Node second = lList.head.next;

		List<Integer> deleteList = new ArrayList<Integer>();
		while (second != null) {
			if ((first.data + second.data) == 0) {
				deleteList.add(first.data);
				deleteList.add(second.data);
			}
			second = second.next;
			first = first.next;
		}

		for (Integer integer : deleteList) {
			lList.removeElement(lList, integer);
		}

		System.out.println("After removeZeroSumElements ");

		lList.printList(lList.head);
	}

	private void removeZeroSumUsingStack(SumEqualsZero lList, Node head) {
		if (lList.head == null) {
			System.out.println("No Elements in the list");
		}

		Node temp = lList.head;
		Stack<Node> stack = new Stack<Node>();

		boolean flag = false;

		while (temp != null) {
			if (temp.data > 0) {
				stack.push(temp);
			} else {
				int sum = temp.data;
				List<Node> list = new ArrayList<Node>();
				while (!stack.isEmpty()) {
					Node stackNode = stack.pop();
					if(stackNode.data<0) {
						break;
					}
					sum += stackNode.data;
					if (sum == 0) {
						list.clear();
						flag = true;
						break;
					}
					list.add(stackNode);
				}

				if (!flag) {
					list.forEach(i -> stack.push(i));
					stack.push(temp);
				}
			}
			temp = temp.next;
		}

		System.out.println("After removeZeroSumUsingStack ");

		stack.forEach(i -> System.out.print(i.data+ " "));
	}

	public static void main(String args[]) {
		SumEqualsZero lList = new SumEqualsZero();

		lList.insertAtStart(4);
		lList.insertAtStart(2);
		lList.insertAtStart(2);
		lList.insertAtStart(11);
		lList.insertAtStart(-90);
		lList.insertAtStart(90);
		lList.insertAtStart(-100);

		System.out.println("Initial LinkedList :");
		lList.printList(lList.head);

		// lList.removeZeroSumElementsConsecutive(lList, lList.head);

		lList.removeZeroSumUsingStack(lList, lList.head);
	}
}
