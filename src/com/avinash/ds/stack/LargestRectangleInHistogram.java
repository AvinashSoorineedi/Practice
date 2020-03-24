package com.avinash.ds.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new ArrayList<>(Arrays.asList(2, 1, 5, 6, 2, 3))));
    }

    public static int largestRectangleArea(ArrayList<Integer> A) {
        int maxArea = 0;
        int maxAreaOnTop = 0;
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        while (i < A.size()) {
            if (stack.isEmpty() || A.get(i) >= A.get(stack.peek())) {
                stack.push(i);
                i++;
            } else {
                maxAreaOnTop = A.get(stack.pop()) * (stack.isEmpty() ? i : i - stack.peek() - 1);
                if (maxAreaOnTop > maxArea) {
                    maxArea = maxAreaOnTop;
                }
            }
        }

        while (!stack.isEmpty()) {
            maxAreaOnTop = A.get(stack.pop()) * (stack.isEmpty() ? i : i - stack.peek() - 1);
            if (maxAreaOnTop > maxArea) {
                maxArea = maxAreaOnTop;
            }
        }

        return maxArea;
    }
}
