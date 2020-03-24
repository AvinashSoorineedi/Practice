package com.avinash.ds.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MaxDistance {

	public static void main(String[] args) {

		List<Integer> l = new ArrayList<>();
		l.add(100);
		l.add(100);
		l.add(100);
		l.add(100);
		l.add(100);

		System.out.println(maximumGap(l));

	}

	public static int maximumGap(final List<Integer> A) {

		int maxDiff;
		int i, j;

		int n = A.size();
		int RMax[] = new int[n];
		int LMin[] = new int[n];

		LMin[0] = A.get(0);

		for (i = 1; i < n; ++i) {
			LMin[i] = Math.min(A.get(i), LMin[i - 1]);
		}

		RMax[n - 1] = A.get(n - 1);
		for (j = n - 2; j >= 0; --j) {
			RMax[j] = Math.max(A.get(j), RMax[j + 1]);
		}

		i = 0;
		j = 0;
		maxDiff = 0;
		while (j < n && i < n) {
			if (LMin[i] <= RMax[j]) {
				maxDiff = Math.max(maxDiff, j - i);
				j++;
			} else {
				i++;
			}
		}

		return maxDiff;
	}
}
