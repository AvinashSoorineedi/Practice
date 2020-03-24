package com.avinash.ds.heap;

public class Heap {

    private int index;
    private int[] A;
    private int size;

    public Heap() {
        index = 0;
        A = new int[16];
        size = 16;

    }

    public void add(int value) {
        if (index + 1 == size) {
            System.out.println("Size is full");
        }
        A[++index] = value;

        int k = index;
        int parent = k / 2;

        while (parent >= 1 && A[parent] < A[k]) {
            swap(A, parent, k);
            k = parent;
            parent = parent / 2;
        }
    }

    public int peek() {
        return A[1];
    }

    public int pop() {
        int parent = A[1];

        A[1] = A[index];
        index--;

        heapifyDown(A, 1);

        return parent;
    }

    public void print() {
        for (int i = 1; i <= index; i++) {
            System.out.println(A[i]);
        }
    }

    private void heapifyDown(int[] A, int i) {
        int largest = i;
        int left = 2 * i;
        int right = 2 * i + 1;

        if (left < A.length && A[left] > A[largest]) {
            largest = left;
        }

        if (right < A.length && A[right] > A[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(A, i, largest);
            heapifyDown(A, largest);
        }
    }

    private void swap(int[] A, int parent, int index) {
        int temp = A[parent];
        A[parent] = A[index];
        A[index] = temp;
    }
}
