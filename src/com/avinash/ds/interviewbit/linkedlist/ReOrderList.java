package com.avinash.ds.interviewbit.linkedlist;

import java.util.Stack;

public class ReOrderList {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
//        l1.next.next.next = new ListNode(4);
//        l1.next.next.next.next = new ListNode(5);
//        l1.next.next.next.next.next = new ListNode(6);
//        l1.next.next.next.next.next.next = new ListNode(7);

        LinkedListUtil.printList(reorderList(l1));
    }

    public static ListNode reorderList(ListNode A) {

        if (A.next == null) {
            return A;
        }

        ListNode end = A;
        ListNode middle = A;

        int middleLength = 1;
        while (end != null && end.next != null && end.next.next != null) {
            middleLength++;
            middle = middle.next;
            end = end.next.next;
        }

        Stack<ListNode> reorderElements = new Stack<>();

        middle = middle.next;
        while (middle != null) {
            ListNode temp = middle.next;
            middle.next = null;
            reorderElements.push(middle);
            middle = temp;
        }

        int index = 0;
        ListNode curr = A;
        ListNode next = null;
        ListNode prev = A;
        boolean isFirstTime = true;
        while (index < middleLength && !reorderElements.isEmpty()) {
            index++;
            next = reorderElements.pop();
            if (isFirstTime) {
                isFirstTime = false;
            } else {
                prev.next = curr;

            }
            ListNode temp = curr.next;
            curr.next = next;
            prev = next;
            curr = temp;
        }

        if (!reorderElements.isEmpty()) {
            ListNode lastElement = reorderElements.pop();
            lastElement.next = null;
            curr.next = lastElement;
        } else {
            prev.next = curr;
            curr.next = null;
        }

        return A;
    }

}
