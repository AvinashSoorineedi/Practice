package com.avinash.ds.two.pointer;

import java.util.ArrayList;
import java.util.Arrays;

public class DiffK {

    public static void main(String[] args) {
        System.out.println(diffPossible(new ArrayList<>(Arrays.asList(1, 3, 5)), 5));
    }

    public static int diffPossible(ArrayList<Integer> A, int B) {
        for (int i = A.size() - 1; i > 0; i--) {
            if (binarySearch(A, 0, i - 1, A.get(i) - B)) {
                return 1;
            }
        }
        return 0;
    }

    private static boolean binarySearch(ArrayList<Integer> A, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (A.get(mid).equals(target)) {
                return true;
            } else if (A.get(mid) > target) {
                return binarySearch(A, start, mid - 1, target);
            } else {
                return binarySearch(A, mid + 1, end, target);
            }
        }
        return false;
    }

}
