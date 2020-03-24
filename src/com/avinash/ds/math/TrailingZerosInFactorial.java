package com.avinash.ds.math;

public class TrailingZerosInFactorial {

    public static void main(String[] args) {
        System.out.println(trailingZeroes(9247));
    }

    public static long trailingZeroes(int A) {
        long factorialResult = findFactorial(A);

        int trailingZeroesCount = 0;
        System.out.println(factorialResult);
        
        while (factorialResult > 0) {
            if (factorialResult % 10 == 0) {
                trailingZeroesCount++;
            } else {
                break;
            }
            factorialResult = factorialResult / 10;

        }

        return trailingZeroesCount;
    }

    private static long findFactorial(int a) {

        if (a == 0) {
            return 1;
        }
        return a * findFactorial(a - 1);
    }
}
