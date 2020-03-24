package com.avinash.ds.two.pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class ThreeSumZero {

    public static void main(String[] args) {
        System.out.println(
            threeSum(new ArrayList<>(Arrays.asList(1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3))));
    }

    public static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        Collections.sort(A);

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (A.size() > 3) {

            for (int i = 0; i < A.size() - 2; i++) {
                if (i > 0 && A.get(i).equals(A.get(i - 1))) {
                    continue;
                }
                int a = i;
                int b = i + 1;
                int c = A.size() - 1;
                while (b < c) {
                    ArrayList<Integer> triplet = new ArrayList<>();

                    int value = A.get(a) + A.get(b) + A.get(c);
                    if (value == 0) {
                        triplet.add(A.get(a));
                        triplet.add(A.get(b));
                        triplet.add(A.get(c));
                        result.add(triplet);
                        b++;
                        c--;
                        while ((b < c) && A.get(b).equals(A.get(b - 1))) {
                            b++;
                        }
                        while ((b < c) && A.get(c).equals(A.get(c + 1))) {
                            c--;
                        }
                    } else if (value > 0) {
                        c--;
                    } else {
                        b++;
                    }

                }
            }

        }

        return result;

    }

}
