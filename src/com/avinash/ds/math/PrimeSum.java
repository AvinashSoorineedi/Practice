package com.avinash.ds.math;

import java.util.ArrayList;

public class PrimeSum {

	public static void main(String[] args) {
		System.out.println(primesum(28));
	}

	public static ArrayList<Integer> primesum(int A) {
		ArrayList<Integer> primesList = new ArrayList<>();
		ArrayList<Integer> result = new ArrayList<>();

		for (int i = 2; i <= A; i++) {
			if (isPrime(i)) {
				primesList.add(i);
			}
		}

		int start = 0;
		int end = primesList.size() - 1;
		int startValue = primesList.get(start);
		int endValue = primesList.get(end);

		result.add(0);
		result.add(0);

		while (start <= end) {
			if ((primesList.get(start) + primesList.get(end)) == A) {

				if (primesList.get(start) > startValue && primesList.get(end) < endValue) {
					result.set(0, primesList.get(start));
					result.set(1, primesList.get(end));
				}
				start++;
//				result.add(primesList.get(start));
//				result.add(primesList.get(end));
//				break;
			} else if ((primesList.get(start) + primesList.get(end)) > A) {
				end--;
			} else {
				start++;
			}
		}

		return result;
	}

	private static boolean isPrime(int i) {

		boolean isPrime = true;
		for (int j = 2; j < Math.sqrt(i); j++) {
			if (i % j == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
}
