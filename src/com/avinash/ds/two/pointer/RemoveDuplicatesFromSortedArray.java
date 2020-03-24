package com.avinash.ds.two.pointer;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new ArrayList<>(Arrays.asList(1, 1, 1, 2))));
    }

    public static int removeDuplicates(ArrayList<Integer> a) {

        if (a.size() < 2) {
            return a.size();
        }

        int last = a.size() - 1;
        int lastBefore = a.size() - 2;
        int matchCount = 0;
        while (lastBefore >= 0 && last >= 0) {
            if (a.get(last).equals(a.get(lastBefore)) && matchCount >= 1) {
                a.remove(last);
            }else if(a.get(last).equals(a.get(lastBefore))) {
                matchCount++;
            } else if (!a.get(last).equals(a.get(lastBefore))) {
                matchCount = 0;
            }
            last--;
            lastBefore--;
        }

        return a.size();
    }

}
