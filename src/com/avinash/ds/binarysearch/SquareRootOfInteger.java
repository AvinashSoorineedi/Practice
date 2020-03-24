package com.avinash.ds.binarysearch;

public class SquareRootOfInteger {

    public static void main(String[] args) {
        System.out.println(sqrt(930675566));
    }

    public static int sqrt(int a) {
        if (a == 0 || a == 1) {
            return a;
        }
        long start = 1, end = a;
        while (start <= end) {
            long mid = (start + end) / 2;

            if (mid * mid == a) {
                return (int) mid;
            } else if (mid * mid > a) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return (int) end;
    }
}
