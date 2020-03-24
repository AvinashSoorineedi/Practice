package com.avinash.ds.two.pointer;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeTwoSortedList {

    public static void main(String[] args) {
        merge(new ArrayList<>(Arrays.asList(1, 5, 8)), new ArrayList<>(Arrays.asList(6, 9)));
    }

    public static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        int index = 0;
        int first = 0;
        int second = 0;

        while (second < b.size() && first < a.size()) {
            if (b.get(second) < a.get(first)) {
                a.add(index, b.get(second));
                index++;
                first++;
                second++;
            } else {
                first++;
                index++;
            }
        }

        while (second < b.size()) {
            a.add(b.get(second));
            second++;
        }

    }
}
