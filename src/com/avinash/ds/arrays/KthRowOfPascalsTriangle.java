package com.avinash.ds.arrays;

import java.util.ArrayList;

public class KthRowOfPascalsTriangle {

	public static void main(String[] args) {

		System.out.println(getRow(3));
	}

	public static ArrayList<Integer> getRow(int A) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();

		ArrayList<Integer> firstRow = new ArrayList<>();
		firstRow.add(1);

		result.add(firstRow);
		for (int i = 1; i <= A; i++) {
			ArrayList<Integer> row = new ArrayList<>();
			row.add(1);
			for (int j = 1; j < result.get(i - 1).size(); j++) {
				row.add(result.get(i - 1).get(j) + result.get(i - 1).get(j - 1));
			}
			row.add(1);
			result.add(row);
		}

		return result.get(A);
	}
}
