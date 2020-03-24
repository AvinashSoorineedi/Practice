package com.avinash.ds.math;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SumOfHammingDistance {

    public static void main(String[] args) {
        List<Integer> in = new ArrayList<>();
        in.add(96);
        in.add(96);
        in.add(7);
        in.add(81);
        in.add(2);
        in.add(13);
        //        in.add(2);
        //        in.add(2);
        //        in.add(4);
        System.out.println(1<<1);
        //System.out.println(hammingDistance(in));
    }

    public static int hammingDistance(final List<Integer> A) {
        long sum = 0;
        long n = A.size();
        int M = 1000000007;
        for (long i = 0; i < 31; i++) {
            long counter = 0;

            for (int j = 0; j < n; j++) {
                if (((long) A.get(j) & (long) (1 << i)) > 0) {
                    counter++;
                }
            }

            sum = (sum + counter * (n - counter)) % M;

        }
        return (int) (sum << 1) % M;
    }

}
