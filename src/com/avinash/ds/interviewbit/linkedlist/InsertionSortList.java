package com.avinash.ds.interviewbit.linkedlist;

public class InsertionSortList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(1);
        l1.next.next.next = new ListNode(5);
        l1.next.next.next.next = new ListNode(8);
        l1.next.next.next.next.next = new ListNode(6);
        l1.next.next.next.next.next.next = new ListNode(2);
        l1.next.next.next.next.next.next.next = new ListNode(7);
        LinkedListUtil.printList(insertionSortList(l1));
    }

    public static ListNode insertionSortList(ListNode A) {
        if (A.next == null) {
            return A;
        }
        ListNode head = A;

        ListNode curr = A.next;

        ListNode currNext = curr.next;
        ListNode currPrev = A;

        while (currNext != null) {

            ListNode temp = head;
            ListNode prevTemp = head;
            boolean swapped = false;
            while (temp != null) {
                if (curr == temp) {
                    break;
                }
                if (curr.val < temp.val) {
                    if (temp == head) {
                        head = curr;
                        curr.next = temp;
                    } else {
                        prevTemp.next = curr;
                        curr.next = temp;
                    }
                    currPrev.next = currNext;
                    curr = currPrev.next;

                    currNext = curr.next;
                    swapped = true;
                    break;
                }

                prevTemp = temp;
                temp = temp.next;
               
            }
            if (!swapped) {
                currPrev = currPrev.next;
                curr = currPrev.next;
                currNext = curr.next;
            }
        }
        
        ListNode temp = head;
        ListNode prevTemp = head;
        while (temp != null) {
            if (curr == temp) {
                break;
            }
            if (curr.val < temp.val) {
                if (temp == head) {
                    head = curr;
                    curr.next = temp;
                } else {
                    prevTemp.next = curr;
                    curr.next = temp;
                }
                currPrev.next = currNext;
                curr = currPrev.next;

                break;
            }

            prevTemp = temp;
            temp = temp.next;
           
        }

        return head;
    }
}
