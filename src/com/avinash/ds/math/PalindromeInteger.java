package com.avinash.ds.math;

public class PalindromeInteger {

    public static void main(String[] args) {
        System.out.println(isPalindrome(12121));
    }

    public static int isPalindrome(int A) {
        StringBuffer sb = new StringBuffer();
        int temp = A;
        if (A > 0) {
            while (A > 0) {
                sb.append(A % 10);
                A = A / 10;
            }
            if (sb.toString().equals(String.valueOf(temp))) {
                return 1;
            } else {
                return 0;
            }
        } else if (A == 0) {
            return 1;
        }
        return 0;
    }
}
