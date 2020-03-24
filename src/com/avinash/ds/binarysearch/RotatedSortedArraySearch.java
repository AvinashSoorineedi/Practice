package com.avinash.ds.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotatedSortedArraySearch {

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<Integer>();
        //        a.add(4);
        //        a.add(5);
        //        a.add(6);
        //        a.add(7);
        //
        //        a.add(0);
        //        a.add(1);
        //        a.add(2);
        //        a.add(10);
        Integer[] arr = { 101, 103, 106, 109, 158, 164, 182, 187, 202, 205, 2, 3, 32, 57, 69, 74, 81, 99, 100 };
        a = Arrays.asList(arr);
        //        a.add(9);
        //        a.add(8);
        //        a.add(7);
        //        a.add(0);
        //        a.add(1);
        //        a.add(2);
        //
        //        a.add(3);
        //        a.add(4);
        //        a.add(5);
        System.out.println(search(a, 202));

    }

    public static int search(final List<Integer> a, int b) {

        if (!a.isEmpty()) {
            int pivotPosition = 0;
            int mid = (a.size() - 1) / 2;
            if (a.get(mid) > a.get(a.size() - 1)) {
                pivotPosition = findPivot(mid + 1, a.size() - 1, a);
            } else {
                pivotPosition = findPivot(0, mid, a);
            }

            System.out.println(pivotPosition);
            return Math.max(binarySearch(0, pivotPosition - 1, a, b), binarySearch(pivotPosition, a.size() - 1, a, b));
        }
        return -1;
    }

    private static int findPivot(int start, int end, List<Integer> a) {

        while (start <= end) {
            int mid = (start + end) / 2;
            if ((mid > 1 && a.get(mid) < a.get(mid - 1)) || (mid < a.size() - 1 && a.get(mid) > a.get(mid + 1))) {
                return mid;
            } else if (a.get(mid) > a.get(end)) {
                return findPivot(mid + 1, end, a);
            } else {
                return findPivot(start, mid - 1, a);
            }
        }
        return -1;
    }

    private static int binarySearch(int i, int j, List<Integer> a, int target) {
        while (i <= j) {
            int mid = (i + j) / 2;
            if (a.get(mid) == target) {
                return mid;
            } else if (a.get(mid) > target) {
                return binarySearch(i, mid - 1, a, target);
            } else {
                return binarySearch(mid + 1, j, a, target);
            }
        }
        return -1;
    }

}
