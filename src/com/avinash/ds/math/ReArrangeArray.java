package com.avinash.ds.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReArrangeArray {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        arrange(list);
    }

    public static void arrange(ArrayList<Integer> a) {
        Map<Integer, Integer> indexVsValue = new HashMap<>();

        for (int i = 0; i < a.size(); i++) {
            indexVsValue.put(i, a.get(i));
        }
        for (int i = 0; i < a.size(); i++) {
            a.set(i, indexVsValue.get(a.get(i)));
        }

    }
}
