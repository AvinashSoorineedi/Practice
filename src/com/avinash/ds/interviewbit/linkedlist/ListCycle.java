package com.avinash.ds.interviewbit.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class ListCycle {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(6);
        l1.next.next.next.next.next.next = new ListNode(7);
        l1.next.next.next.next.next.next.next = l1.next;

        System.out.println(detectCycle(l1).val);
    }

    public static ListNode detectCycle(ListNode a) {

        Map<ListNode, Integer> nodeMap = new HashMap<>();
        if (a.next != null) {
            ListNode temp = a;
            while (temp != null) {
                if (nodeMap.containsKey(temp)) {
                    return temp;
                } else {
                    nodeMap.put(temp, temp.val);
                }
                temp = temp.next;
            }
        }
        return null;

    }

}
