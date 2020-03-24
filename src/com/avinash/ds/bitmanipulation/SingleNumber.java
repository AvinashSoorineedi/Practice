package com.avinash.ds.bitmanipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SingleNumber {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 2, 3, 1);
        System.out.println(singleNumber(new ArrayList<Integer>(list)));
    }

    public static int singleNumber(final List<Integer> A) {
        int aggregate = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            aggregate = aggregate ^ A.get(i);
        }
        return aggregate;
    }
}
