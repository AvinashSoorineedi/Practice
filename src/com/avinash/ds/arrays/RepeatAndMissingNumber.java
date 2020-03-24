package com.avinash.ds.arrays;

import java.util.ArrayList;
import java.util.List;

public class RepeatAndMissingNumber {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(5);
		System.out.println(repeatedNumber(list));
	}

	public static ArrayList<Integer> repeatedNumber(final List<Integer> A) {

		int[] arr = new int[A.size() + 1];
		ArrayList<Integer> result = new ArrayList<>();
		int duplicate = 0;
		int missing = 0;
		for (int i = 0; i < A.size(); i++) {

			if (arr[A.get(i)] == -1) {
				duplicate = A.get(i);
			} else {
				arr[A.get(i)] = -1;
			}
		}

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != -1) {
				missing = i;
				break;
			}
		}

		result.add(duplicate);
		result.add(missing);

		return result;
	}
}
