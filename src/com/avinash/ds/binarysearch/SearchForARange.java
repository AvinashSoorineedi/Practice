package com.avinash.ds.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class SearchForARange {

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<Integer>();
        input.add(5);
        input.add(7);
        input.add(7);
        input.add(7);
        input.add(7);
        input.add(7);
        input.add(7);
        input.add(7);
        input.add(7);
        input.add(7);
        input.add(7);
        input.add(7);
        input.add(7);
        input.add(8);
        input.add(10);

        System.out.println(searchRange(input, 8));
    }

    public static ArrayList<Integer> searchRange(final List<Integer> a, int b) {

        ArrayList<Integer> result = new ArrayList<Integer>();

        if (a.isEmpty()) {
            result.add(-1);
            result.add(-1);
            return result;
        }

        int start = 0;
        int end = a.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (a.get(mid) == b) {
                int min = Math.min(mid, binaryMinSearch(a, 0, mid - 1, a.get(mid)));
                int max = Math.max(mid, binaryMaxSearch(a, mid + 1, a.size() - 1, a.get(mid)));
                result.add(min);
                result.add(max);
                return result;
            } else if (a.get(mid) > b) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        result.add(-1);
        result.add(-1);
        return result;
    }

    private static int binaryMaxSearch(List<Integer> a, int start, int end, int target) {

        while (start <= end) {
            int mid = (start + end) / 2;
            if (a.get(mid) == target) {
                return Math.max(mid, binaryMaxSearch(a, mid + 1, a.size() - 1, target));
            } else if (a.get(mid) > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return Integer.MIN_VALUE;
    }

    private static int binaryMinSearch(List<Integer> a, int start, int end, int target) {

        while (start <= end) {
            int mid = (start + end) / 2;
            if (a.get(mid) == target) {
                return Math.min(mid, binaryMinSearch(a, 0, mid - 1, target));
            } else if (a.get(mid) > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return Integer.MAX_VALUE;

    }

    //    private static int getMaxIndex(List<Integer> a, int mid) {
    //        int max = mid;
    //        for (int i = mid + 1; i < a.size(); i++) {
    //            if (a.get(i) == a.get(mid) && i > max) {
    //                max = i;
    //            } else {
    //                break;
    //            }
    //        }
    //        return max;
    //    }
    //
    //    private static int getMinIndex(List<Integer> a, int mid) {
    //        int min = mid;
    //        for (int i = mid - 1; i >= 0; i--) {
    //            if (a.get(i) == a.get(mid) && i < min) {
    //                min = i;
    //            } else {
    //                break;
    //            }
    //        }
    //        return min;
    //    }

}
