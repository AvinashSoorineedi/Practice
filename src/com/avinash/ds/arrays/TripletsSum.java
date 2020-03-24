package com.avinash.ds.arrays;

import java.util.Arrays;
import java.util.List;

public class TripletsSum {

	public static void main(String[] args) {
		String[] arr = { "0.480294", "0.298444", "1.109334" };
		System.out.println(solve(Arrays.asList(arr)));
	}

	public static int solve(List<String> A) {

		float[] arr = new float[A.size()];
		for (int i = 0; i < A.size(); i++) {
			arr[i] = Float.parseFloat(A.get(i));
		}

		Arrays.sort(arr);

		if (arr.length >= 3) {
			int x = 0;
			int y = 1;
			int z = arr.length - 1;
			while (y < z) {
				float tripletSum = arr[x] + arr[y] + arr[z];
				if (tripletSum > 1 && tripletSum < 2) {
					return 1;
				} else if (tripletSum > 2) {
					z--;
				} else if (tripletSum < 1) {
					x++;
					y++;
				}
			}
		}

		return 0;
	}
}
