package com.avinash.ds.interviewbit.linkedlist;

public class RemoveDuplicates {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        //        l1.next.next = new ListNode(2);
        //                l1.next.next.next = new ListNode(2);
        //                l1.next.next.next.next = new ListNode(2);
        //                l1.next.next.next.next.next = new ListNode(2);
        LinkedListUtil.printList(deleteDuplicates(l1));
    }

    public static ListNode deleteDuplicates(ListNode A) {

        if (A.next != null) {
            ListNode curr = A;
            ListNode next = A.next;

            while (next != null) {

                if (curr.val == next.val) {
                    if (next.next != null) {
                        curr.next = next.next;
                        next = next.next;
                    } else {
                        curr.next = null;
                        next = next.next;
                    }
                } else {
                    curr = next;
                    next = next.next;
                }

            }
        }

        return A;
    }

}
