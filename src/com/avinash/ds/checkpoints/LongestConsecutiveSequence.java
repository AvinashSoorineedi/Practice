package com.avinash.ds.checkpoints;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        System.out.println(longestConsecutive(Arrays.asList(100, 4, 200, 1, 3, 2)));
    }

    public static int longestConsecutive(final List<Integer> A) {
        List<Integer> myList = A;
        int longestLengthTemp = 0;
        int longestLength = 0;

        Collections.sort(myList);
        
        for (int i = 0; i < myList.size() - 1; i++) {
            if (myList.get(i + 1) - myList.get(i) == 1) {
                longestLengthTemp++;
                if (longestLengthTemp > longestLength) {
                    longestLength = longestLengthTemp;
                }
            } else if (myList.get(i + 1) - myList.get(i) == 0) {
                //do Nothing
            } else {
                longestLengthTemp = 0;
            }
        }
        return longestLength + 1;
    }
}
