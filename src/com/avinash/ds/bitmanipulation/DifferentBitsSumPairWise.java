package com.avinash.ds.bitmanipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DifferentBitsSumPairWise {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 5);
        //cntBits(numbers);
    }

    public static int cntBits(ArrayList<Integer> A) {
        int ans = 0; // Initialize result 

        // traverse over all bits 
        for (int i = 0; i < 32; i++) {

            // count number of elements  
            // with i'th bit set 
            int count = 0;

            for (int j = 0; j < A.size(); j++)
                if ((A.get(j) & (1 << i)) == 0)
                    count++;

            // Add "count * (n - count) * 2"  
            // to the answer 
            ans += (count * (A.size() - count) * 2);
        }

        return ans;
    }

}
