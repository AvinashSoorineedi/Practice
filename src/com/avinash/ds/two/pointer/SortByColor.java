package com.avinash.ds.two.pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortByColor {

    public static void main(String[] args) {
        sortColors(new ArrayList<>(Arrays.asList(1, 0, 0, 1, 1, 0, 0, 2, 1, 2, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1,
            0, 0, 2, 0, 2, 2, 2, 0, 0, 1, 1, 1, 2, 2, 0, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 1, 2, 1, 1, 0, 0, 1, 2, 1, 1, 0,
            1, 0, 2, 0, 2, 1, 0, 1, 1, 0, 0, 1, 2, 0, 1, 0, 2, 1, 0, 1, 0, 1, 0, 1, 2, 2, 2, 0, 1, 1, 0, 2, 2, 2, 0, 0,
            0, 0, 1, 1, 2, 1, 0, 1, 0, 1, 2, 2, 1, 0, 2, 0, 0, 1, 2, 1, 0, 2, 1, 0, 2, 0, 2, 1, 1, 1, 1, 1, 0, 1, 2, 0,
            0, 1, 0, 1, 2, 0, 1, 1, 2, 1, 0, 2, 0, 0, 0, 2, 0, 1, 0, 2, 1, 1, 0, 1, 2, 1, 0, 0)));
    }

    public static void sortColors(ArrayList<Integer> a) {
        if (a.size() > 1) {
            mergeSort(a, 0, a.size() - 1);
        }
    }

    private static void mergeSort(ArrayList<Integer> a, int start, int end) {

        if (start < end) {
            mergeSort(a, start, (start + end) / 2);
            mergeSort(a, ((start + end) / 2) + 1, end);
            merge(a, start, (start + end) / 2, end);
        }

    }

    private static void merge(ArrayList<Integer> a, int start, int mid, int end) {

        int first = start;
        int second = mid + 1;
        int index = first;

        List<Integer> temp = new ArrayList<>();

        while (first <= mid && second <= end) {
            if (a.get(first) <= a.get(second)) {
                temp.add(a.get(first));
                first++;
            } else {
                temp.add(a.get(second));
                second++;
            }
        }

        while (first <= mid) {
            temp.add(a.get(first));
            first++;
        }

        while (second <= end) {
            temp.add(a.get(second));
            second++;
        }

        for (int i = 0; i < temp.size(); i++) {
            a.set(index, temp.get(i));
            index++;
        }
    }

}
