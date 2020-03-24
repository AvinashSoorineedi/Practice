package com.avinash.ds.stack;

import java.util.Stack;

public class MinStack {

    public static void main(String[] args) {

    }

    class Solution {

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        public Solution() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty() || x < minStack.peek()) {
                minStack.push(x);
            }
        }

        public void pop() {
            if (!stack.isEmpty()) {
                int val = stack.pop();
                if (val == minStack.peek()) {
                    minStack.pop();
                }
            }
        }

        public int top() {
            if (stack.isEmpty()) {
                return -1;
            }
            return stack.peek();
        }

        public int getMin() {
            if (minStack.isEmpty()) {
                return -1;
            }
            return minStack.peek();
        }
    }
}
