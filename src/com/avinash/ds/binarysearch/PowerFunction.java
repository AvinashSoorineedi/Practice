package com.avinash.ds.binarysearch;

public class PowerFunction {

    public static void main(String[] args) {
        System.out.println(pow(71045970, 41535484, 64735492));
    }

    public static int pow(int x, int n, int d) {
        long result = calPow(x, n, d);

        return (int) (result + d) % d;
    }

    private static long calPow(int x, int n, int d) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        long res;
        if (n % 2 == 0) {
            res = calPow(x, n / 2, d);
            res = (res * res) % d;
        } else {
            res = x % d;
            res = (res * calPow(x, n - 1, d) % d) % d;
        }

        return res;
    }
}
