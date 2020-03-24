package com.avinash.ds.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MaximumConsecutiveGap {

	public static void main(String[] args) {

		List<Integer> l = new ArrayList<Integer>();
		l.add(1);
		l.add(13);
		l.add(5);
		System.out.println(maximumGap(l));
	}

	public static int maximumGap(final List<Integer> A) {
		int result = 0;
		if (A.size() < 2) {
			return result;
		}

		List<Integer> list = A.parallelStream().sorted().collect(Collectors.toList());
		
		for (int i = 0; i < list.size()-1; i++) {
			if ((list.get(i + 1) - list.get(i)) > result) {
				result = list.get(i + 1) - list.get(i);
			}
		}
		return result;
	}
}
