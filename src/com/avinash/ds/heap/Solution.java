package com.avinash.ds.heap;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    DoublyLinkedList doublyLinkedList = null;

    public Solution(int capacity) {
        doublyLinkedList = new DoublyLinkedList(capacity);
    }

    public int get(int key) {
        return doublyLinkedList.getValue(key);
    }

    public void set(int key, int value) {
        Node node = new Node(key, value);
        doublyLinkedList.add(node);
    }

    class DoublyLinkedList {

        Node head;
        Node tail;
        int size;

        Map<Integer, Node> keys = new HashMap<>();

        public DoublyLinkedList(int size) {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            this.size = size;
        }

        public int getValue(int key) {
            if (keys.containsKey(key)) {
                Node node = keys.get(key);
                Node front = node.prev;
                Node back = node.next;
                front.next = back;
                back.prev = front;

                Node temp = head.next;
                head.next = node;
                node.prev = head;
                node.next = temp;
                temp.prev = node;

                return keys.get(key).value;
            }
            return -1;
        }

        public void print() {
            Node temp = head.next;
            while (temp.next != null) {
                System.out.print(temp.key);
                temp = temp.next;
            }
            System.out.println();
        }

        public void add(Node node) {

            if (keys.containsKey(node.key)) {
                Node temp1 = keys.get(node.key);
                Node front = temp1.prev;
                Node back = temp1.next;
                front.next = back;
                back.prev = front;
                //keys.remove(node.key);

                keys.put(node.key, node);
                Node temp = head.next;
                head.next = node;
                node.prev = head;
                node.next = temp;
                temp.prev = node;
            } else {
                if (size == keys.size()) {
                    Node temp = tail.prev;
                    temp.prev.next = tail;
                    tail.prev = temp.prev;
                    keys.remove(temp.key);
                }
                keys.put(node.key, node);
                Node temp = head.next;
                head.next = node;
                node.prev = head;
                node.next = temp;
                temp.prev = node;
            }
            //print();
        }
    }

    public class Node {
        private int key;
        private int value;
        private Node next;
        private Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
