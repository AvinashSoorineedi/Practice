package com.avinash.ds.two.pointer;

import java.util.ArrayList;

public class MinimizeAbsoluteDifference {

    public static void main(String[] args) {

    }
    
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {

        int i = 0;
        int j = 0;
        int k = 0;

        int ans = Integer.MAX_VALUE;

        while (i < A.size() && j < B.size() && k < C.size()) {
            int minVal = Math.min(A.get(i), Math.min(B.get(j), C.get(k)));
            int maxVal = Math.max(A.get(i), Math.max(B.get(j), C.get(k)));

            if (ans > maxVal - minVal) {
                ans = maxVal - minVal;
            }

            if (minVal == A.get(i))
                i++;
            else if (minVal == B.get(j))
                j++;
            else
                k++;
        }

        return ans;
    
    }

}
