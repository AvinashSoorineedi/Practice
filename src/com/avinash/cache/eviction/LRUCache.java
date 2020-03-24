package com.avinash.cache.eviction;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    Map<String, DoublyLinkedNode> values;
    DoublyLinkedList evictionList;
    int capacity;

    public LRUCache() {
        values = new HashMap<>();
        evictionList = new DoublyLinkedList();
        capacity = 3;
    }

    public int getFromCache(String key, int value) {

        if (values.get(key) != null) {
            DoublyLinkedNode node = values.get(key);
            evictionList.remove(node);
            evictionList.addNodeAtStart(new DoublyLinkedNode(key, value));
            return node.value;
        } else {
            DoublyLinkedNode node = new DoublyLinkedNode(key, value);
            if (values.size() == capacity) {
                DoublyLinkedNode removalNode = evictionList.evictFromEnd();
                values.remove(removalNode.key);
            }
            values.put(key, node);
            evictionList.addNodeAtStart(node);
            return value;
        }

    }

    public class DoublyLinkedList {

        DoublyLinkedNode head, tail;

        public DoublyLinkedList() {
            head = new DoublyLinkedNode("head", 0);
            tail = new DoublyLinkedNode("tail", 0);
            head.next = tail;
            tail.prev = head;
        }

        public DoublyLinkedNode remove(DoublyLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            printList();
            return node;
        }

        public void addNodeAtStart(DoublyLinkedNode node) {
            DoublyLinkedNode temp = head.next;
            head.next = node;
            node.prev = head;
            node.next = temp;
            temp.prev = node;

            printList();
        }

        public DoublyLinkedNode evictFromEnd() {
            DoublyLinkedNode temp = tail.prev;
            temp.prev.next = tail;
            tail.prev = temp.prev;

            printList();
            return temp;
        }

        public void printList() {
            DoublyLinkedNode temp = head;
            while (temp != null) {
                System.out.println("key: " + temp.key + " value: " + temp.value);
                temp = temp.next;
            }
        }
    }

    class DoublyLinkedNode {
        DoublyLinkedNode next, prev;
        String key;
        int value;

        public DoublyLinkedNode(String key, int value) {
            this.key = key;
            this.value = value;
            next = null;
            prev = null;
        }

        DoublyLinkedNode() {
            next = null;
            prev = null;
        }

        @Override
        public String toString() {
            return "DoublyLinkedNode [next=" + next + ", prev=" + prev + ", key=" + key + ", value=" + value + "]";
        }

    }
}
