package com.avinash.ds.bitmanipulation;

public class NumberOf1Bits {

    public static void main(String[] args) {
        System.out.println(numSetBits(11));
    }

    public static int numSetBits(long a) {

        int count = 0;
        while (a > 0) {
            count += a % 2;
            a >>= 1;
        }
        return count;
    }
}
