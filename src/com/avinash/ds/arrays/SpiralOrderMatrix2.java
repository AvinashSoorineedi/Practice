package com.avinash.ds.arrays;

import java.util.ArrayList;

public class SpiralOrderMatrix2 {

	public static void main(String[] args) {

		System.out.println(generateMatrix(3));
	}

	public static ArrayList<ArrayList<Integer>> generateMatrix(int A) {
		ArrayList<ArrayList<Integer>> rows = new ArrayList<>();

		for (int i = 0; i < A; i++) {
			ArrayList<Integer> column = new ArrayList<>();
			for (int j = 0; j < A; j++) {
				column.add(0);
			}
			rows.add(column);
		}
		int n = 1;
		int up = 0;
		int down = A;
		int left = 0;
		int right = A;

		while (up < down && left < right) {

			for (int i = left; i < right; i++) {
				rows.get(up).set(i, n);
				n++;
			}
			up++;

			for (int i = up; i < down; i++) {
				rows.get(i).set(right-1, n);
				n++;
			}
			right--;

			for (int i = right - 1; i >= left; i--) {
				rows.get(down-1).set(i, n);
				n++;
			}
			down--;

			for (int i = down - 1; i >= up; i--) {
				rows.get(i).set(left, n);
				n++;
			}
			left++;
		}

		return rows;
	}
}
