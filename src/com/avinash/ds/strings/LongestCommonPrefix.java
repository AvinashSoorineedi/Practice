package com.avinash.ds.strings;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new ArrayList<>(Arrays.asList("abab", "ab", "abcd"))));
    }

    public static String longestCommonPrefix(ArrayList<String> A) {
        if (A.size() > 0) {
            StringBuilder sb = new StringBuilder();
            boolean terminate = false;
            String smallestString = A.get(0);
            for (int i = 0; i < A.size(); i++) {
                if (A.get(i).length() < smallestString.length()) {
                    smallestString = A.get(i);
                }
            }
            for (int i = 0; i < smallestString.length(); i++) {
                char ref = A.get(0).charAt(i);
                if (terminate) {
                    break;
                }
                for (int j = 0; j < A.size(); j++) {
                    if (A.get(j).charAt(i) != ref) {
                        terminate = true;
                        break;
                    }
                }
                if (!terminate) {
                    sb.append(ref);
                }

            }
            return sb.toString();
        }
        return null;
    }
}
