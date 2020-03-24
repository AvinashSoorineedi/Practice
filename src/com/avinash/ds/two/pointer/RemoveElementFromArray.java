package com.avinash.ds.two.pointer;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveElementFromArray {

    public static void main(String[] args) {
        System.out.println(removeElement(new ArrayList<>(Arrays.asList(4, 1, 1, 2, 1, 3)), 1));
    }

    public static int removeElement(ArrayList<Integer> a, int b) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) != b) {
                result.add(a.get(i));
            }
        }
        a.clear();
        a.addAll(result);
        return result.size();
    }

}
