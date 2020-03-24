package com.avinash.ds.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class MedianOfArray {

    public static void main(String[] args) {

        List<Integer> a = new ArrayList<Integer>();
        List<Integer> b = new ArrayList<Integer>();
                a.add(-50);
                a.add(-41);
                a.add(-40);
                a.add(-19);
                a.add(5);
                a.add(21);
                a.add(28);

                b.add(-50);
                b.add(-21);
                b.add(-10);
                
        System.out.println(findMedianSortedArrays(a, b));
    }

    public static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {

        if(a.size()==1 && b.isEmpty()) {
            return a.get(0);
        }
        
        if(b.size()==1 && a.isEmpty()) {
            return b.get(0);
        }
        
        if (a.size() > b.size()) {
            return findMedianSortedArrays(b, a);
        }

        int n = a.size();
        int m = b.size();

        int start = 0;
        int end = n;

        while (start <= end) {
            int partitionX = (start + end) / 2;
            int partitionY = ((n + m + 1) / 2) - partitionX;

            int leftMaxX = (partitionX == 0) ? Integer.MIN_VALUE : a.get(partitionX - 1);
            int leftMaxY = (partitionY == 0) ? Integer.MIN_VALUE : b.get(partitionY - 1);

            int rightMinX = (partitionX == n) ? Integer.MAX_VALUE : a.get(partitionX);
            int rightMinY = (partitionY == m) ? Integer.MAX_VALUE : b.get(partitionY);

            if (leftMaxX <= rightMinY && leftMaxY <= rightMinX) {
                if ((m + n) % 2 == 0) {
                    return ((double) (Math.max(leftMaxX, leftMaxY) + Math.min(rightMinX, rightMinY)) / 2);
                } else {
                    return (double) Math.max(leftMaxX, leftMaxY);
                }
            } else if (leftMaxX > rightMinY) {
                end = partitionX - 1;
            } else {
                start = partitionX + 1;
            }

        }
        return 0;
    }
}
