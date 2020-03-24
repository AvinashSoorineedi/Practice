package com.avinash.ds.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PaintersPartition {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1000000, 1000000);
        System.out.println(paint(1, 1000000, new ArrayList<>(list)));
    }

    public static int paint(int A, int B, ArrayList<Integer> C) {
        if (C.size() == 1) {
            return (C.get(0) * B) % 10000003;
        }
        else if (C.size() >= 2) {
            int maxTime = 0;
            int minTime = 0;
            for (int i = 0; i < C.size(); i++) {
                maxTime += C.get(i);
                minTime = Math.max(minTime, C.get(i));

            }
            int res = (int) ((binarySearchMinTime(minTime, maxTime, C, A) * B)%10000003);
            return res;
        }
        return 0;
    }

    private static long binarySearchMinTime(int minTime, int maxTime, ArrayList<Integer> c, int paintersCount) {
        while (minTime <= maxTime) {
            int mid = (minTime + maxTime) / 2;
            if (isValidMinTime(mid, paintersCount, c) == 0) {
                return Math.min(mid, binarySearchMinTime(minTime, mid - 1, c, paintersCount));
            } else {
                return binarySearchMinTime(mid + 1, maxTime, c, paintersCount);
            }
        }
        return Integer.MAX_VALUE;
    }

    private static int isValidMinTime(int mid, int paintersCount, ArrayList<Integer> c) {
        int paintersRequired = 1;
        int maxCount = 0;
        for (int i = 0; i < c.size(); i++) {
            maxCount = maxCount + c.get(i);
            if (maxCount > mid) {
                paintersRequired++;
                maxCount = 0;
                i--;
            }
        }
        if (paintersRequired <= paintersCount) {
            return 0;
        }
        return -1;

    }
}
