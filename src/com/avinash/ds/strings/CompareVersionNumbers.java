package com.avinash.ds.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompareVersionNumbers {

    public static void main(String[] args) {
        System.out.println(compareVersion("444444444444444444444444", "4444444444444444444444444"));
    }

    public static int compareVersion(String A, String B) {
        String[] firstArr;
        if (A.contains(".")) {
            firstArr = A.split("\\.");
        } else {
            firstArr = new String[1];
            firstArr[0] = A;
        }
        String[] secArr;
        if (B.contains(".")) {
            secArr = B.split("\\.");
        } else {
            secArr = new String[1];
            secArr[0] = B;
        }

        List<String> first = new ArrayList<>(Arrays.asList(firstArr));
        List<String> second = new ArrayList<>(Arrays.asList(secArr));

        if (first.size() < second.size()) {
            for (int i = 0; i < (second.size() - first.size()); i++) {
                first.add("0");
            }
        } else if (first.size() > second.size()) {
            for (int i = 0; i < (first.size() - second.size()); i++) {
                second.add("0");
            }
        }

        for (int i = 0; i < first.size(); i++) {
            if (Double.parseDouble(first.get(i)) > Double.parseDouble(second.get(i))) {
                return 1;
            } else if (Double.parseDouble(first.get(i)) < Double.parseDouble(second.get(i))) {
                return -1;
            }
        }

        return 0;
    }

}
