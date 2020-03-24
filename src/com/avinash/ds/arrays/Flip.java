package com.avinash.ds.arrays;

import java.util.ArrayList;

public class Flip {

	public static void main(String[] args) {

		System.out.println(flip("1101010001"));

	}

	public static ArrayList<Integer> flip(String A) {
		char[] input = A.toCharArray();

		ArrayList<Integer> result = new ArrayList<>();
		ArrayList<Integer> inverse = new ArrayList<>();
		int numOfOnes = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] == '1') {
				inverse.add(-1);
				numOfOnes++;
			} else {
				inverse.add(1);
			}
		}

		if (numOfOnes == input.length) {
			return result;
		}

		int thisMaxLeft = 0;
		int thisMaxRight = 0;
		int thisMaxSum ;
		int prevMaxSum = inverse.get(0);

		int maxLeft = 0;
		int maxRight = 0;
		int maxSum = inverse.get(0);

		for (int i = 1; i < inverse.size(); i++) {
			int prevPlusThisNum = inverse.get(i) + prevMaxSum;
			if (inverse.get(i) > prevPlusThisNum) {
				thisMaxLeft = i;
				thisMaxRight = i;
				thisMaxSum = inverse.get(i);
			} else {
				thisMaxRight = i;
				thisMaxSum = prevPlusThisNum;
			}

			if (thisMaxSum > maxSum) {
				maxLeft = thisMaxLeft;
				maxRight = thisMaxRight;
				maxSum = thisMaxSum;
			}
			prevMaxSum = thisMaxSum;
		}
		
		result.add(maxLeft+1);
		result.add(maxRight+1);
		
		return result;
	}

}
