package com.avinash.ds.two.pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {

        List<Integer> input = Arrays.asList(10, -6, 3, 4, -8, -5);
        System.out.println(threeSumClosest(new ArrayList<Integer>(input), 3));
    }

    public static int threeSumClosest(ArrayList<Integer> A, int B) {
        if (A.size() < 3) {
            return -1;
        }

        Collections.sort(A);
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < A.size(); i++) {
            int start = i;
            int lastBefore = i + 1;
            int last = A.size() - 1;
            while (lastBefore < last) {
                if (Math.abs(A.get(start) + A.get(last) + A.get(lastBefore) - B) < Math.abs(minDiff-B)) {
                    minDiff = A.get(start) + A.get(last) + A.get(lastBefore);
                }
                if (A.get(start) + A.get(last) + A.get(lastBefore) < B) {
                    lastBefore++;
                } else if (A.get(start) + A.get(last) + A.get(lastBefore) == B) {
                    return B;
                } else if (A.get(start) + A.get(last) + A.get(lastBefore) > B) {
                    last--;
                }
            }
        }

        return minDiff;
    }
}
