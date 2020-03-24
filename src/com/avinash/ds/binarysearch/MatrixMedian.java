package com.avinash.ds.binarysearch;

import java.util.ArrayList;

public class MatrixMedian {

    public static void main(String[] args) {

        ArrayList<Integer> input1 = new ArrayList<>();
        ArrayList<Integer> input2 = new ArrayList<>();
        ArrayList<Integer> input3 = new ArrayList<>();
        ArrayList<Integer> input4 = new ArrayList<>();
        ArrayList<Integer> input5 = new ArrayList<>();

        //        input1.add(1);
        //        input1.add(3);
        //        input1.add(5);
        //
        //        input2.add(2);
        //        input2.add(6);
        //        input2.add(9);
        //
        //        input3.add(3);
        //        input3.add(6);
        //        input3.add(9);
//
        input1.add(1);
        input1.add(2);
        input1.add(3);
        input1.add(4);
        input1.add(5);
//        input1.add(2);
//        
//        input1.add(3);
//        input1.add(3);
//        input1.add(3);
//        input1.add(3);
//        input1.add(3);

        input2.add(6);
        input2.add(7);
        input2.add(8);
        input2.add(9);
        input2.add(10);

        input3.add(11);
        input3.add(12);
        input3.add(13);
        input3.add(14);
        input3.add(15);

        input4.add(16);
        input4.add(17);
        input4.add(18);
        input4.add(19);
        input4.add(20);

        input5.add(21);
        input5.add(22);
        input5.add(23);
        input5.add(24);
        input5.add(25);

        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(input1);
        input.add(input2);
        input.add(input3);
        input.add(input4);
        input.add(input5);

        System.out.println(findMedian(input));
    }

    public static int findMedian(ArrayList<ArrayList<Integer>> A) {
        if (A != null && A.size() > 0) {

            int arrMin = Integer.MAX_VALUE;
            int arrMax = Integer.MIN_VALUE;

            for (int i = 0; i < A.size(); i++) {
                if (A.get(i).get(0) < arrMin) {
                    arrMin = A.get(i).get(0);
                }

                if (A.get(i).get(A.get(0).size() - 1) > arrMax) {
                    arrMax = A.get(i).get(A.get(0).size() - 1);
                }
            }

            int desired = ((A.size() * A.get(0).size()) / 2) + 1;

            while (arrMin < arrMax) {
                int mid = (arrMin + arrMax) / 2;

                int position = 0;

                for (int i = 0; i < A.size(); i++) {
                    position = position + getLessElementsCount(A.get(i), mid);
                }

                if (position < desired) {
                    arrMin = mid + 1;
                } else {
                    arrMax = mid;
                }
            }

            return arrMin;
        }
        return -1;
    }

    private static int getLessElementsCount(ArrayList<Integer> A, int mid) {
        int count = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) <= mid) {
                count++;
            }
        }
        return count;
    }

}
