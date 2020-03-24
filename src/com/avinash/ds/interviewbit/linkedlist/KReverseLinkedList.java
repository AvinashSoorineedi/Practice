package com.avinash.ds.interviewbit.linkedlist;

import java.util.Stack;

public class KReverseLinkedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(6);
        //        l1.next.next.next.next.next.next = new ListNode(2);
        //        l1.next.next.next.next.next.next.next = new ListNode(7);
        LinkedListUtil.printList(reverseList(l1, 3));
    }

    public static ListNode reverseList(ListNode A, int B) {

        if (A.next == null || B == 1 || B == 0) {
            return A;
        }

        ListNode head = A;
        ListNode curr = A;
        ListNode first = A;

        Stack<ListNode> stack = new Stack<>();

        while (curr != null) {

            if (stack.size() < B) {
                stack.push(curr);
                curr = curr.next;
            } else {
                ListNode last = null;
                ListNode rightMost = null;
                while (!stack.isEmpty()) {
                    if (last != null) {
                        ListNode lastSecond = stack.pop();
                        last.next = lastSecond;
                        last = lastSecond;
                    } else {
                        ListNode firstPop = stack.pop();
                        last = firstPop;
                        rightMost = firstPop;
                    }
                }
                if (first == head) {
                    head = rightMost;
                } else {
                    first.next = rightMost;
                }
                first = last;

            }
        }

        ListNode last = null;
        ListNode rightMost = null;
        while (!stack.isEmpty()) {
            if (last != null) {
                ListNode lastSecond = stack.pop();
                last.next = lastSecond;
                last = lastSecond;
            } else {
                ListNode firstPop = stack.pop();
                last = firstPop;
                rightMost = firstPop;
            }
        }
        if (first == head) {
            head = rightMost;
        } else {
            first.next = rightMost;
        }
        last.next = null;
        first = last;

        return head;
    }

}
