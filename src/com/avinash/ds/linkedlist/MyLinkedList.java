package com.avinash.ds.linkedlist;

public class MyLinkedList {

	private int length = 0;

	private Node head;

	public MyLinkedList() {}

	public MyLinkedList(String data) {	
		this.head = new Node(data, null);
		++this.length;
	}

	public void addFirst(String x) {
		addElementFirst(new Node(x, null));
	}
	
	private void addElementFirst(Node data) {

		if (length == 0) {
			this.head = data;
			++length;
		} else {
			Node temp = this.head;
			head = data;
			head.setNext(temp);
			++length;
		}

	}
	
	public String getElementWithIndex(int index) {
		if(length==0) {
			return null;
		}else if(index == 0){
			return head.getData();
		}else {
			int i = 1;
			Node temp = head.getNext();
			while(temp!=null) {
				if(i == index) {
					return temp.getData();
				}else {
					i++;
				}
				
				temp = temp.getNext();
			}
		}
		
		return null;
	}
	
	public String getFirst() {
		if(length==0) {
			return null;
		}else {
			return head.getData();
		}
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
}
