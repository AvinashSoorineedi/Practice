package com.avinash.ds.two.pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfSortedArrays {

    public static void main(String[] args) {
        System.out.println(intersect(Arrays.asList(1, 2, 3, 3, 4, 5, 6), Arrays.asList(3, 5)));
    }

    public static ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {

        if (A.size() > B.size()) {
            return intersect(B, A);
        }
        ArrayList<Integer> result = new ArrayList<>();

        int smallArrSize = A.size();
        int largeArrSize = B.size();

        int smallArrPointer = 0;
        int largeArrPointer = 0;

        while (smallArrPointer < smallArrSize && largeArrPointer < largeArrSize) {
            if (A.get(smallArrPointer) > B.get(largeArrPointer)) {
                largeArrPointer++;
            } else if (A.get(smallArrPointer) < B.get(largeArrPointer)) {
                smallArrPointer++;
            } else {
                result.add(A.get(smallArrPointer));
                smallArrPointer++;
                largeArrPointer++;
            }
        }

        return result;
    }
}
