package com.avinash.ds.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortedInsertPosition {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 5, 6);
        ArrayList<Integer> in = new ArrayList<>(list);
        System.out.println(searchInsert(in, 2));
    }

    public static int searchInsert(ArrayList<Integer> a, int b) {
        return binarySearch(0, a.size() - 1, a, b);
    }

    private static int binarySearch(int i, int j, ArrayList<Integer> a, int b) {

        while (i <= j) {
            int mid = (i + j) / 2;
            if (a.get(mid) == b) {
                return mid;
            } else if (a.get(mid) > b) {
                return binarySearch(i, mid - 1, a, b);
            } else {
                return binarySearch(mid + 1, j, a, b);
            }
        }

        return i;
    }
}
