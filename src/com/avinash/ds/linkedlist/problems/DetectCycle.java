package com.avinash.ds.linkedlist.problems;

public class DetectCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	boolean hasCycle(Node head) {
		Node temp = head;
		Node temp1 = head;
		
		while(temp1!=null && temp1.next!=null) {
			temp = temp.next;
			temp1 = temp1.next.next;
				
			if(temp == temp1) {
				return true;
			}
			
		}
		
		return false;
	}
	
}
