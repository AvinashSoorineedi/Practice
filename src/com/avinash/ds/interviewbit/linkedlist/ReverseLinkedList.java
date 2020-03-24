package com.avinash.ds.interviewbit.linkedlist;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(6);
        LinkedListUtil.printList(reverseBetween(l1, 2, 5));
    }

    public static ListNode reverseBetween(ListNode A, int B, int C) {
        if (A.next == null) {
            return A;
        }

        int length = 1;
        ListNode head = A;
        ListNode curr = A;
        ListNode first = null;

        ListNode prev = null;
        boolean isHeadIncludedInReverse = false;
        boolean properEnd = false;

        while (curr != null) {

            if (length >= B && length <= C) {
                if (first == null && prev != null) {
                    first = prev;
                    prev.next = null;
                } else if (first == null && prev == null) {
                    first = head;
                    isHeadIncludedInReverse = true;
                }

                ListNode currTemp = curr;
                ListNode nextTemp = curr.next;
                if (prev == head) {
                    ListNode headTemp = head;
                    headTemp.next = null;
                    currTemp.next = headTemp;
                } else {
                    currTemp.next = prev;
                }
                prev = curr;
                curr = nextTemp;
            } else if (length > C) {

                ListNode second = prev;
                ListNode prevNext = prev;
                while (prevNext.next != null && prevNext.next.next != null) {
                    prevNext = prevNext.next;
                }
                if (isHeadIncludedInReverse) {
                    head = second;
                    prevNext.next.next = curr;
                } else {
                    first.next = second;
                    prevNext.next = curr;
                }
                properEnd = true;
                break;
            } else {
                if (prev == null) {
                    prev = head;
                } else {
                    prev = prev.next;
                }
                curr = curr.next;
            }

            length++;
        }

        if (!properEnd) {
            ListNode second = prev;
            ListNode prevNext = prev;
            while (prevNext.next != null && prevNext.next.next != null) {
                prevNext = prevNext.next;
            }
            if (isHeadIncludedInReverse) {
                head = second;
                prevNext.next.next = curr;
            } else {
                first.next = second;
                prevNext.next = curr;
            }
        }
        return head;
    }

}
