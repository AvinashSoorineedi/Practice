package com.avinash.ds.arrays;

import java.math.BigInteger;
import java.util.ArrayList;

public class AddOneToNumber {

	public static void main(String[] args) {

		ArrayList<Integer> arr = new ArrayList<>();
//		arr.add(9);
//		arr.add(9);
//		arr.add(9);
//		arr.add(9);
//		arr.add(9);
//		arr.add(9);
//		arr.add(9);
//		arr.add(9);
//		arr.add(9);
//		arr.add(9);
//		arr.add(9);
//		arr.add(9);
//
//		arr.add(9);
//		arr.add(9);
//		arr.add(9);
//		arr.add(9);
//		arr.add(9);
//		arr.add(9);
//		arr.add(9);

		
		arr.add(0);
		arr.add(0);
		arr.add(4);
		arr.add(4);
		arr.add(6);
		arr.add(0);
		arr.add(9);
		arr.add(6);
		arr.add(5);
		arr.add(1);

		System.out.println(plusOne(arr));
	}

	public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {

		ArrayList<Integer> result = new ArrayList<>();
		if (A.size() == 1 && A.get(0) == 0) {
			result.add(1);
			return result;
		}

		ArrayList<Integer> subResult = new ArrayList<>();
		ArrayList<Integer> subResult2 = new ArrayList<>();
		int zeroCount = 0;
		for (int i = 0; i < A.size(); i++) {
			if (A.get(i) == 0) {
				zeroCount++;
			} else {
				break;
			}
		}
		for (int i = (A.size() - 1); i >= zeroCount; i--) {
			subResult.add(A.get(i));
		}

		int carry = 1;
		for (int i = 0; i < subResult.size(); i++) {
			int elem = carry + subResult.get(i);
			if (elem >= 10) {
				carry = elem / 10;
				elem = elem % 10;

			} else {
				carry = 0;
			}
			subResult2.add(elem);
		}

		if (carry == 1) {
			subResult2.add(1);
		}

		for (int i = subResult2.size() - 1; i >= 0; i--) {
			result.add(subResult2.get(i));
		}

		return result;
	}
}
