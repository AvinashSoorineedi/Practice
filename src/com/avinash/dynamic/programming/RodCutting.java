package com.avinash.dynamic.programming;

public class RodCutting {

	public static void main(String[] args) {

		int[] price = { 1, 200, 6, 2, 1000, 1 };

		int length = 10;

		System.out.println(calculateMaximumProfit(price, length));

	}

	private static int calculateMaximumProfit(int[] prices, int size) {

		int count = Integer.min(prices.length, size);

		if (size < 0) {
			return 0;
		}
		int max = 0;
		for (int i = 1; i <= count; i++) {

			max = Integer.max(max, prices[i - 1] + calculateMaximumProfit(prices, size - i));
		}

		return max;
	}
}
