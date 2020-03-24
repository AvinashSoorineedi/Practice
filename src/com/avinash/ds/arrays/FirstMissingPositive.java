package com.avinash.ds.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class FirstMissingPositive {

	public static void main(String[] args) {

		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(3);
		arr.add(4);
		arr.add(-1);
		arr.add(1);

		System.out.println(firstMissingPositive(arr));
	}

	public static int firstMissingPositive(ArrayList<Integer> A) {

		// remove negative numbers
		A = (ArrayList<Integer>) A.parallelStream().filter(i -> (i > 0)).collect(Collectors.toList());

		int output = 1;

		if (!A.isEmpty()) {
			int[] arr = new int[Collections.max(A) + 1];

			for (int i = 0; i < A.size(); i++) {
				arr[A.get(i)] = 1;
			}

			for (int i = 1; i < arr.length; i++) {
				if (arr[i] != 1) {
					return i;
				}
				output = i + 1;
			}
		}

		return output;
	}

}
