package com.avinash.ds.two.pointer;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicateFromSortedArray {

    public static void main(String[] args) {

        System.out.println(removeDuplicates(new ArrayList<>(Arrays.asList(1,1,2))));
    }

    public static int removeDuplicates(ArrayList<Integer> a) {

        if (a.size() < 2) {
            return a.size();
        }
        int size = a.size();
        int begin = size - 2;
        int next = size - 1;

        while (begin >= 0 && next >= 0) {
            if (a.get(begin).equals(a.get(next))) {
                a.remove(next);
            }
            begin--;
            next--;
        }
        return a.size();
    }
}
