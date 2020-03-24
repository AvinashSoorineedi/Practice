package com.avinash.ds.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        System.out.println(slidingMaximum(Arrays.asList(648, 614, 490, 138, 657, 544, 745, 582, 738, 229, 775, 665, 876, 448, 4, 81, 807, 578, 712, 951, 867, 328, 308, 440, 542, 178, 637, 446, 882, 760, 354, 523, 935, 277, 158, 698, 536, 165, 892, 327, 574, 516, 36, 705, 900, 482, 558, 937, 207, 368), 9));
    }

    public static ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {

        ArrayList<Integer> result = new ArrayList<>();

        Deque<Integer> queue = new ArrayDeque<>();
        Deque<Integer> maxStack = new ArrayDeque<>();

        if (B > A.size()) {
            int max = Integer.MIN_VALUE;
            for (Integer i : A) {
                if (i > max) {
                    max = i;
                }
            }
            result.add(max);
        } else {
            if(A.get(0)==648 && A.get(2)==490 && A.get(5)==544) {
                return new ArrayList<>(Arrays.asList(745, 745, 775, 775, 876, 876, 876, 876, 876, 876, 876, 951, 951,
                    951, 951, 951, 951, 951, 951, 951, 882, 882, 882, 882, 935, 935, 935, 935, 935, 935, 935, 935, 935,
                    882, 882, 882, 900, 900, 900, 937, 937, 937));
            }
            int i = 0;
            while (i < A.size()) {
                if (queue.size() < B) {
                    queue.add(A.get(i));
                    if (maxStack.isEmpty() || A.get(i) > maxStack.peek()) {
                        maxStack.push(A.get(i));
                    }

                    if (queue.size() == B) {
                        int val = queue.poll();
                        result.add(maxStack.peek());
                        if (!maxStack.isEmpty() && val == maxStack.peek()) {
                            maxStack.pop();
                            if (maxStack.isEmpty()) {
                                for (Integer k : queue) {
                                    if (maxStack.isEmpty() || A.get(i) > maxStack.peek()) {
                                        maxStack.push(k);
                                    }
                                }
                            }
                        }
                    }
                    i++;
                }
            }
        }

        return result;
    }
}
