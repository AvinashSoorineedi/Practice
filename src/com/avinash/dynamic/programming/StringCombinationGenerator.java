package com.avinash.dynamic.programming;

public class StringCombinationGenerator {

    public static void main(String[] args) {

        String input = "abc";

        generateStringCombinations(input.toCharArray(), 0);

    }

    private static void generateStringCombinations(char[] input, int start) {
        if (start == (input.length - 1)) {
            System.out.println(input);
        } else {
            for (int i = start; i < input.length; i++) {
                swap(input, start, i);
                generateStringCombinations(input, start + 1);
                swap(input, i, start);
            }
        }
    }

    private static void swap(char[] inputArr, int a, int b) {
        char temp = inputArr[a];
        inputArr[a] = inputArr[b];
        inputArr[b] = temp;
    }
}
