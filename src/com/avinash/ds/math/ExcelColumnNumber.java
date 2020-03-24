package com.avinash.ds.math;

import java.util.HashMap;
import java.util.Map;

public class ExcelColumnNumber {

    public static void main(String[] args) {
        System.out.println(titleToNumber("AZ"));
    }

    public static int titleToNumber(String A) {

        Map<String, Integer> alphabets = new HashMap<>();

        alphabets.put("A", 1);
        alphabets.put("B", 2);
        alphabets.put("C", 3);
        alphabets.put("D", 4);
        alphabets.put("E", 5);
        alphabets.put("F", 6);
        alphabets.put("G", 7);

        alphabets.put("H", 8);
        alphabets.put("I", 9);
        alphabets.put("J", 10);
        alphabets.put("K", 11);
        alphabets.put("L", 12);
        alphabets.put("M", 13);
        alphabets.put("N", 14);

        alphabets.put("O", 15);
        alphabets.put("P", 16);
        alphabets.put("Q", 17);
        alphabets.put("R", 18);
        alphabets.put("S", 19);
        alphabets.put("T", 20);
        alphabets.put("U", 21);

        alphabets.put("V", 22);
        alphabets.put("W", 23);
        alphabets.put("X", 24);
        alphabets.put("Y", 25);
        alphabets.put("Z", 26);

        int count = A.length();
        int sum = 0;
        while (count > 0) {
            sum = (int) (sum + (Math.pow(26, A.length() - count) * alphabets.get(String.valueOf(A.charAt(count-1)))));
            count--;
        }

        return sum;

    }

}
