package com.avinash.ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllocateBooks {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(12, 34, 67, 90);
        ArrayList<Integer> input = new ArrayList<>(list);
        System.out.println(books(input, 2));
    }

    public static int books(ArrayList<Integer> A, int B) {
        if(A.isEmpty() || (A.size()==2 && B==0) || A.size()<B) {
            return -1;
        }
        int minPages = Integer.MIN_VALUE;
        int maxPages = 0;

        for (int i = 0; i < A.size(); i++) {
            minPages = Math.max(minPages, A.get(i));
            maxPages += A.get(i);
        }
        
        return findMinimumPagesRequired(minPages, maxPages, A, B);
    }

    private static int findMinimumPagesRequired(int minPages, int maxPages, ArrayList<Integer> a, int b) {

        while (minPages <= maxPages) {
            int mid = (minPages + maxPages) / 2;
            if (getMinPagesByBinarySearch(mid, a, b) == 0) {
                return Math.min(mid, findMinimumPagesRequired(minPages, mid - 1, a, b));
            } else {
                return findMinimumPagesRequired(mid + 1, maxPages, a, b);
            }
        }
        return Integer.MAX_VALUE;
    }

    private static int getMinPagesByBinarySearch(int mid, ArrayList<Integer> a, int b) {
        int aggregate = 0;
        int personCount = 1;
        for (int i = 0; i < a.size(); i++) {
            aggregate += a.get(i);
            if (aggregate > mid) {
                personCount++;
                aggregate = a.get(i);
            }

            if (personCount > b) {
                break;
            }
        }
        if (personCount <= b) {
            return 0;
        } else {
            return -1;
        }
    }
}
