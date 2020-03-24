package com.avinash.ds.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class EvaluateExpression {

    public static void main(String[] args) {
        System.out.println(evalRPN(new ArrayList<>(Arrays.asList("2", "1", "+", "3", "*"))));
    }

    public static int evalRPN(ArrayList<String> A) {

        Stack<Integer> stack = new Stack<>();

        for (String a : A) {
            if (a.equalsIgnoreCase("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (a.equalsIgnoreCase("-")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val2 - val1);
            } else if (a.equalsIgnoreCase("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (a.equalsIgnoreCase("/")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val2 / val1);
            } else {
                stack.push(Integer.valueOf(a));
            }
        }
        return stack.pop();
    }
}
