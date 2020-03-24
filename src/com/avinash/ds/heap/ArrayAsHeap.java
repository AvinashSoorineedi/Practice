package com.avinash.ds.heap;

public class ArrayAsHeap {

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.add(5);
        heap.add(4);
        heap.add(6);
        heap.add(2);
        heap.add(9);
        heap.print();
        System.out.println("Popped element is " + heap.pop());
        heap.print();
        System.out.println("Popped element is " + heap.pop());
        heap.print();
        
    }

}
