package com.avinash.ds.stack;

import java.util.Stack;

public class RedundantBraces {

    public static void main(String[] args) {
        System.out.println(braces("(a+b)"));
    }

    public static int braces(String A) {

        char[] arr = A.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (char c : arr) {
            if (c == ')') {
                char operator = stack.pop();
                if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
                    return 1;
                }
                char brace = stack.pop();
                if (brace != '(') {
                    return 1;
                }
            } else if(c == '(' || c == '+' || c == '-' || c == '*' || c == '/') {
                stack.push(c);
            }
        }

        return 0;
    }

}
