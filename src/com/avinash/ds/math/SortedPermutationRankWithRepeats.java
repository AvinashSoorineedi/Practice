package com.avinash.ds.math;

import java.util.HashMap;
import java.util.Map;

public class SortedPermutationRankWithRepeats {

    public static void main(String[] args) {
        System.out.println(findRank("aba"));
    }

    public static int findRank(String A) {
        char[] charsInString = A.toCharArray();
        long result = 0;

        for (int i = 0; i < charsInString.length; i++) {
            Map<Character, Integer> charCount = new HashMap<>();
            //            int count = charCount.containsKey(charsInString[i]) ? charCount.get(charsInString[i]) + 1 : 1;

            if (!charCount.containsKey(charsInString[i])) {
                charCount.put(charsInString[i], 1);
                int charsLessThanThePresentOne = calculateCharsLessThanThePresentOne(i + 1, charsInString,
                    charsInString[i]) / charCount.get(charsInString[i]);
                result += charsLessThanThePresentOne * calculateFactorial(charsInString.length - i - 1);
            }

        }

        return (int) result % 1000003;
    }

    private static int calculateFactorial(int i) {
        if (i == 0 || i == 1) {
            return 1;
        }
        return i * calculateFactorial(i - 1);
    }

    private static int calculateCharsLessThanThePresentOne(int start, char[] charsInString, char charToCheckAgainst) {
        int count = 0;
        for (int i = start; i < charsInString.length; i++) {
            if (charsInString[i] <= charToCheckAgainst) {
                count++;
            }
        }
        return count;
    }

}
