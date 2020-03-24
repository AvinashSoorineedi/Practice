package com.avinash.ds.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MaximumAbsoluteDifference {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(3);
		list.add(-1);
		System.out.println(maxArr(list));
	}

	public static int maxArr(ArrayList<Integer> A) {
		int max = 0;
		List<Integer> indexList = new ArrayList<>();
		List<Integer> sortedList = A.parallelStream().sorted().collect(Collectors.toList());
		for (int i = 0; i < A.size(); i++) {
			indexList.add(A.indexOf(sortedList.get(i)));
		}
		for (int i = sortedList.size() - 1; i >= 0; i--) {
			if ((Math.abs(sortedList.get(i) - sortedList.get(0))
					+ Math.abs(indexList.get(i) - indexList.get(0))) > max) {
				max = Math.abs(sortedList.get(i) - sortedList.get(0)) + Math.abs(indexList.get(i) - indexList.get(0));
			}
		}

		return max;
	}
	
	
}
