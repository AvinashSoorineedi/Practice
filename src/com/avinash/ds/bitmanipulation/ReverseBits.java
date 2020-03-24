package com.avinash.ds.bitmanipulation;

public class ReverseBits {

    public static void main(String[] args) {
        System.out.println(reverse(3));
    }

    public static long reverse(long a) {
        int position = 0;
        long value = 0;
        while (a > 0) {
            if (a % 2 == 1) {
                value += Math.pow(2, 31 - position);
            }
            a = a >> 1;
            position++;
        }
        return value;
    }
}
