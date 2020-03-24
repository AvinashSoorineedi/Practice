package com.avinash.ds.interviewbit.linkedlist;

import java.util.Stack;

public class RotateList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        //l1.next = new ListNode(2);
        //l1.next.next = new ListNode(3);
        //                l1.next.next.next = new ListNode(4);
        //                l1.next.next.next.next = new ListNode(5);
        ListNode result = rotateRight(l1, 4);
        LinkedListUtil.printList(result);
    }

    public static ListNode rotateRight(ListNode A, int B) {

        ListNode start = A;

        if (start.next == null) {
            return start;
        }

        int kLength = 0;

        int range = 0;

        ListNode len = start;

        while (len != null) {
            kLength++;
            len = len.next;
        }

        if (B > kLength) {
            range = kLength - (B % kLength);

        } else {
            range = kLength - B;
        }

        int index = 0;
        ListNode temp = start;
        ListNode prev = start;

        if (range > 0) {
            while (index < range) {
                index++;
                prev = temp;
                temp = temp.next;
            }

            Stack<ListNode> stack = new Stack<>();
            ListNode rem = temp;
            while (rem != null) {
                stack.push(rem);
                rem = rem.next;
            }

            prev.next = null;

            while (!stack.isEmpty()) {
                ListNode ref = stack.pop();
                ref.next = start;

                start = ref;
            }
        }
        return start;
    }

}
