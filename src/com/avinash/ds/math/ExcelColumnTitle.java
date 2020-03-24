package com.avinash.ds.math;

import java.util.HashMap;
import java.util.Map;

public class ExcelColumnTitle {

    public static void main(String[] args) {
        System.out.println(convertToTitle(943566));
    }

    public static String convertToTitle(int A) {
        Map<Integer, String> alphabets = new HashMap<>();

        alphabets.put(1, "A");
        alphabets.put(2, "B");
        alphabets.put(3, "C");
        alphabets.put(4, "D");
        alphabets.put(5, "E");
        alphabets.put(6, "F");
        alphabets.put(7, "G");

        alphabets.put(8, "H");
        alphabets.put(9, "I");
        alphabets.put(10, "J");
        alphabets.put(11, "K");
        alphabets.put(12, "L");
        alphabets.put(13, "M");
        alphabets.put(14, "N");

        alphabets.put(15, "O");
        alphabets.put(16, "P");
        alphabets.put(17, "Q");
        alphabets.put(18, "R");
        alphabets.put(19, "S");
        alphabets.put(20, "T");
        alphabets.put(21, "U");

        alphabets.put(22, "V");
        alphabets.put(23, "W");
        alphabets.put(24, "X");
        alphabets.put(25, "Y");
        alphabets.put(26, "Z");
        alphabets.put(0, "Z");

        StringBuilder sb = new StringBuilder();

        while (A > 0) {
            sb.append(alphabets.get(A % 26));
            
            if (A % 26 == 0 ) {
               A = A/26 -1;
            } else {
                A = A / 26;
            }
        }

        return sb.reverse().toString();
    }
}
