package com.avinash.ds.math;

public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(-1234567891)); //1146467285
    }

    public static int reverse(int A) {
        if (A == 0) {
            return 0;
        }
        long result = 0;
        boolean isNegative = false;
        if (A < 0) {
            isNegative = true;
        }
        A = Math.abs(A);
        while (A > 0) {
            result = result * 10 + A % 10;
            A = A / 10;
        }

        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        if (isNegative) {
            result = -result;
        }
        return (int) result;
    }
}
