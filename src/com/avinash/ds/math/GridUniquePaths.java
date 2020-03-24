package com.avinash.ds.math;

public class GridUniquePaths {

	public static void main(String[] args) {
		System.out.println(uniquePaths(3, 3));
	}

	public static int uniquePaths(int A, int B) {

		return move(1, 1, A, B);
	}

	private static int move(int down, int right, int downLimit, int rightLimit) {

		if (down > downLimit || right > rightLimit) {
			return 0;
		}
		if (down == downLimit && right == rightLimit) {
			return 1;
		}

		return move(down, right + 1, downLimit, rightLimit) + move(down + 1, right, downLimit, rightLimit);

	}
}
