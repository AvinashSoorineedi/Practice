package com.avinash.dynamic.programming;

public class Knapsack {

	public static void main(String[] args) {

		int[] values = {200, 240, 140, 250};
		int[] weights = {1, 3, 2, 5};
		int w = 6;

		System.out.println(calculateKnapSackValue(values, weights, w, weights.length-1));

	}

	private static int calculateKnapSackValue(int[] values, int[] weights, int w, int index) {

		// base condition
		if (w == 0 || index < 0) {
			return 0;
		}
		if (weights[index] > w) {
			return calculateKnapSackValue(values, weights, w, --index);
		} else {
			int include = values[index] + calculateKnapSackValue(values, weights, w - weights[index], --index);
			int exclude = calculateKnapSackValue(values, weights, w, --index);
			return Math.max(include, exclude);
		}

	}

}
