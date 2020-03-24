package com.avinash.ds.two.pointer;

import java.util.ArrayList;
import java.util.Arrays;

public class ContinuousSeriesOfOnes {

    public static void main(String[] args) {
        System.out.println(maxone(new ArrayList<>(Arrays.asList(1, 1, 0, 1, 1, 0, 0, 1, 1, 1)), 1));
    }

    public static ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
        int wL = 0;
        int wR = 0;
        int nZero = 0;
        int maxOnesRange = -1;
        int lRange = 0;
        int rRange = 0;
        while (wR < A.size()) {
            if (nZero <= B) {
                if (A.get(wR) == 0) {
                    nZero++;
                }
                wR++;
            }

            if (nZero > B) {
                if (A.get(wL) == 0) {
                    nZero--;
                }
                wL++;
            }

            if (wR - wL > maxOnesRange) {
                maxOnesRange = wR - wL;
                lRange = wL;
                rRange = wR;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = lRange; i < rRange; i++) {
            result.add(i);
        }

        return result;
    }

}
