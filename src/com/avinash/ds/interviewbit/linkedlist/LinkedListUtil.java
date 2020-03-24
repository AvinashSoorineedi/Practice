package com.avinash.ds.interviewbit.linkedlist;

public class LinkedListUtil {

    public static void printList(ListNode node) {
        if (node != null) {
            while (node != null) {
                System.out.println(node.val);
                node = node.next;
            }
        }
    }
}
