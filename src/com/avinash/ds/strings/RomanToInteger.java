package com.avinash.ds.strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt("MMCDLXXV"));
    }

    //1000, 1000, 100, 500, 50, 10, 10, 5

    public static int romanToInt(String A) {
        if (A.length() > 0) {
            //I, V, X, L, C, D, M
            Map<String, Integer> romans = new HashMap<>();
            romans.put("I", 1);
            romans.put("II", 2);
            romans.put("III", 3);
            romans.put("IV", 4);
            romans.put("V", 5);
            romans.put("VI", 6);
            romans.put("VII", 7);
            romans.put("VIII", 8);
            romans.put("IX", 9);
            romans.put("X", 10);
            romans.put("L", 50);
            romans.put("C", 100);
            romans.put("D", 500);
            romans.put("M", 1000);

            int sum = 0;
            String letter = "";
            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) == 'I') {
                    letter = letter + String.valueOf(A.charAt(i));
                } else {
                    if (letter.length() > 0) {
                        sum += romans.get(letter + String.valueOf(A.charAt(i)));
                    } else {
                        if ((i + 1 < A.length())
                            && romans.get(String.valueOf(A.charAt(i + 1))) > romans.get(String.valueOf(A.charAt(i)))) {
                            sum -= romans.get(String.valueOf(A.charAt(i)));
                        } else {
                            sum += romans.get(String.valueOf(A.charAt(i)));
                        }
                    }
                    letter = "";
                }
            }

            if (letter.length() > 0) {
                sum += romans.get(letter);
            }
            return sum;
        }
        return 0;
    }
}
