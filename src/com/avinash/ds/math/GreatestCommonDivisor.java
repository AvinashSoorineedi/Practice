package com.avinash.ds.math;

public class GreatestCommonDivisor {

    public static void main(String[] args) {
        System.out.println(gcd(6, 9));
    }

    public static int gcd(int A, int B) {
        if (A < B) {
            return gcd(B, A);
        } else if (B == 0) {
            return A;
        } else {
            return gcd(A % B, B);
        }
    }

}
