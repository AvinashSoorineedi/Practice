package com.avinash.ds.stack;

import java.util.ArrayList;
import java.util.Arrays;

public class NearestSmallestElement {

    public static void main(String[] args) {
        System.out.println(prevSmaller(new ArrayList<>(Arrays.asList(3,2,1))));
    }

    public static ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {

        ArrayList<Integer> result = new ArrayList<>();
        if (!A.isEmpty()) {
            int min = A.get(0);
            result.add(-1);
            for (int i = 1; i < A.size(); i++) {
                boolean smallFound = false;
                if (A.get(i) > min) {
                    int k = i - 1;
                    while (k >= 0) {
                        if (A.get(k) < A.get(i)) {
                            result.add(A.get(k));
                            smallFound = true;
                            break;
                        }
                        k--;
                    }
                }
                if (!smallFound) {
                    result.add(-1);
                }
                min = Math.min(min, A.get(i));
            }
        }

        return result;
    }

}
