package com.avinash.interview.failure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ArrayIntoSubArrayWithConsecutiveElements {

    public static void main(String[] args) {

        int[] input = { 1, 2, 6, 3, 4, 3, 9, 10, 11};
        int k = 3;

        System.out.println(checkIfSplitPossible(input, k));
    }

    private static boolean checkIfSplitPossible(int[] input, int splitNum) {

        if (input.length % splitNum == 0) {
            Map<Integer, Integer> givenElementsRepeatCount = new HashMap<>();

            for (int i = 0; i < input.length; i++) {
                if (givenElementsRepeatCount.get(input[i]) != null) {
                    givenElementsRepeatCount.put(input[i], givenElementsRepeatCount.get(input[i]) + 1);
                } else {
                    givenElementsRepeatCount.put(input[i], 1);
                }
            }

            List<Integer> listWithDuplicates = new ArrayList<>();
            for (int i = 0; i < input.length; i++) {
                listWithDuplicates.add(input[i]);
            }
            listWithDuplicates = listWithDuplicates.stream().distinct().sorted().collect(Collectors.toList());

            boolean noConsecutiveElementFound = false;
            while (!listWithDuplicates.isEmpty()) {
                if (!noConsecutiveElementFound) {
                    int index = listWithDuplicates.size() - 1;
                    for (int i = 0; i < splitNum - 1; i++) {
                        if (index >= 1) {
                            if (listWithDuplicates.get(index) - listWithDuplicates.get(index - 1) == 1) {
                                if (givenElementsRepeatCount.get(listWithDuplicates.get(index)) == 1) {
                                    listWithDuplicates.remove(index);
                                    index--;
                                } else if (givenElementsRepeatCount.get(listWithDuplicates.get(index)) > 1) {
                                    givenElementsRepeatCount.put(listWithDuplicates.get(index),
                                        givenElementsRepeatCount.get(listWithDuplicates.get(index)) - 1);
                                    index--;
                                }
                            } else {
                                noConsecutiveElementFound = true;
                                break;
                            }
                        }
                    }
                    if (givenElementsRepeatCount.get(listWithDuplicates.get(index)) == 1) {
                        listWithDuplicates.remove(index);
                    }
                } else {
                    break;
                }

            }

            return !noConsecutiveElementFound;
        }
        return false;
    }
}
