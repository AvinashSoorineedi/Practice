package com.avinash.ds.strings;

public class LongestPalindromeString {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abbbbbaccbccaaccccacbacaaabbabbbaababbcc"));
    }

    public static String longestPalindrome(String A) {

        if (A.length() == 1) {
            return A;
        }

        StringBuilder sb = new StringBuilder();
        String longestPalindrome = null;
        int maxSize = 1;
        for (int i = 0; i < A.length(); i++) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(A.charAt(i));
        }

        int start = 0;
        int end = sb.length() - 1;
        for (int i = 1; i < sb.length() - 1; i++) {
            int left = i - 1;
            int right = i + 1;
            int size = 0;
            while (left >= start && right <= end) {
                if (sb.charAt(left) != sb.charAt(right)) {
                    left++;
                    right--;
                    break;
                } else {
                    size++;
                    left--;
                    right++;
                }
            }

            if (left < 0) {
                left = 0;
            }
            if (right > sb.length() - 1) {
                right = sb.length() - 1;
            }
            String result = sb.substring(left, right + 1).replaceAll("&", "");
            System.out.println(result);
            if (result.length() > maxSize) {
                maxSize = result.length();
                longestPalindrome = result;
            }
        }

        return ((longestPalindrome == null) ? A.substring(0, 1) : longestPalindrome);
    }

}
