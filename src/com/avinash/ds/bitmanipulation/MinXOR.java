package com.avinash.ds.bitmanipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinXOR {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(15, 5, 1, 10, 2);
        System.out.println(findMinXor(new ArrayList<Integer>(list)));
    }

    public static int findMinXor(ArrayList<Integer> A) {
        A.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        int minXor = Integer.MAX_VALUE;

        for (int i = 0; i < A.size() - 1; i++) {
            if ((A.get(i + 1) ^ A.get(i)) < minXor) {
                minXor = A.get(i + 1) ^ A.get(i);
            }
        }

        return minXor;
    }

}
