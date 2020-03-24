package com.avinash.ds.arrays;

import java.util.ArrayList;

public class PascalTriangle {

	public static void main(String[] args) {

		System.out.println(solve(0));
	}

	public static ArrayList<ArrayList<Integer>> solve(int A) {
		if (A == 0) {
			return new ArrayList<>();
		}
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();
		temp.add(1);
		result.add(temp);

		for (int i = 2; i <= A; i++) {
			ArrayList<Integer> temp1 = new ArrayList<>();
			temp1.add(1);
			for (int j = 1; j < i - 1; j++) {
				temp1.add(result.get(i - 2).get(j) + result.get(i - 2).get(j - 1));
			}
			temp1.add(1);
			result.add(temp1);
		}
		return result;
	}
}
