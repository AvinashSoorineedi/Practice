package com.avinash.ds.interviewbit.linkedlist;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KthSmallestElement {

    public static void main(String[] args) {
        System.out.println(kthsmallest(Arrays.asList(2, 1, 4, 3, 1), 3));
    }

    public static int kthsmallest(final List<Integer> A, int B) {
        List<Object> result = A.parallelStream().sorted().collect(Collectors.toList());
        return (int) result.get(B-1);
    }

}
