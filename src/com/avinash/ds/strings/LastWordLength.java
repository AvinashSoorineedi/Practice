package com.avinash.ds.strings;

public class LastWordLength {

    public static void main(String[] args) {

        System.out.println(lengthOfLastWord(" "));

    }

    public static int lengthOfLastWord(final String A) {
        if (A.length() > 0) {
            String B = A.trim();
            int size = 0;
            for (int i = B.length() - 1; i >= 0; i--) {
                if (B.charAt(i) == ' ') {
                    break;
                }else {
                    size++;
                }
            }
            return size;
        }
        return 0;
    }
}
