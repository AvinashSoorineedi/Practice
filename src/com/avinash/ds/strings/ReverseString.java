package com.avinash.ds.strings;

public class ReverseString {

    public static void main(String[] args) {
        System.out.println(solve("ram is good "));
    }

    public static String solve(String A) {
        A = A.trim();
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = A.length() - 1; i >= 0; i--) {
            if (Character.isWhitespace(A.charAt(i)) && Character.isWhitespace(A.charAt(i + 1))) {

            } else if (Character.isWhitespace(A.charAt(i)) && !Character.isWhitespace(A.charAt(i + 1))) {
                for (int j = temp.length() - 1; j >= 0; j--) {
                    sb.append(temp.charAt(j));
                }
                sb.append(" ");
                temp = new StringBuilder();
            } else {
                temp.append(A.charAt(i));
            }
        }

        if (temp.length() > 0) {
            for (int j = temp.length() - 1; j >= 0; j--) {
                sb.append(temp.charAt(j));
            }
        }
        return sb.toString();
    }
}
