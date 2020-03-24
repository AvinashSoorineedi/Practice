package com.avinash.dynamic.programming;

public class CoinChangeProblem {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 7 };
		int expected = 9;

		int result = minimumCoinsRequired(arr, expected);
		System.out.println(result);
	}

	private static int minimumCoinsRequired(int[] arr, int expected) {

		int coinCount=0;
		int remaining = expected;
		for (int i = arr.length - 1; i >= 0; i--) {
			if(remaining == 0) {
				break;
			}
			if(arr[i]<=remaining) {
				int temp = remaining;
				remaining = remaining%arr[i];
				coinCount = coinCount + (temp-remaining)/arr[i];
			}
			
		}
		
		return coinCount;

	}
}
