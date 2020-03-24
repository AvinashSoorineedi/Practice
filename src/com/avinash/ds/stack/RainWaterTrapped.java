package com.avinash.ds.stack;

import java.util.Arrays;
import java.util.List;

public class RainWaterTrapped {

    public static void main(String[] args) {
        System.out.println(trap(Arrays.asList(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)));
    }

    public static int trap(final List<Integer> A) {
        int left[] = new int[A.size()];
        int right[] = new int[A.size()];

        int max = A.get(0);
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) > max) {
                max = A.get(i);
            }
            left[i] = max;
        }

        int max2 = A.get(A.size() - 1);
        for (int i = A.size() - 1; i >= 0; i--) {
            if (A.get(i) > max2) {
                max2 = A.get(i);
            }
            right[i] = max2;
        }

        int result = 0;
        for (int i = 0; i < A.size(); i++) {
            result += Math.min(left[i], right[i]) - A.get(i);
        }

        return result;
    }

}
