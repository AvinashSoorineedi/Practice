package com.avinash.ds.bitmanipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SingleNumber2 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 4, 3, 2, 2, 4, 4, 3, 3);
        System.out.println(singleNumber(new ArrayList<Integer>(list)));
    }

    public static int singleNumber(final List<Integer> A) {
        int ones = 0, twos = 0;
        int common_bit_mask;

        for (int i = 0; i < A.size(); i++) {
            /*
             * "one & arr[i]" gives the bits that are there in both 'ones' and
             * new element from arr[]. We add these bits to 'twos' using bitwise
             * OR
             */
            twos = twos | (ones & A.get(i));

            /*
             * "one & arr[i]" gives the bits that are there in both 'ones' and
             * new element from arr[]. We add these bits to 'twos' using bitwise
             * OR
             */
            ones = ones ^ A.get(i);

            /*
             * The common bits are those bits which appear third time So these
             * bits should not be there in both 'ones' and 'twos'.
             * common_bit_mask contains all these bits as 0, so that the bits
             * can be removed from 'ones' and 'twos'
             */
            common_bit_mask = ~(ones & twos);

            /*
             * Remove common bits (the bits that appear third time) from 'ones'
             */
            ones &= common_bit_mask;

            /*
             * Remove common bits (the bits that appear third time) from 'twos'
             */
            twos &= common_bit_mask;
        }
        return ones;
    }
}