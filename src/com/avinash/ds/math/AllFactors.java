package com.avinash.ds.math;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class AllFactors {

	public static void main(String[] args) {

		System.out.println(allFactors(6));

	}

	public static ArrayList<Integer> allFactors(int A) {
		ArrayList<Integer> result = new ArrayList<>();

		if (A == 1) {
			result.add(1);
		} else {
			result.add(1);
			result.add(A);
			for (int i = 2; i <= Math.sqrt(A); i++) {
				if (A % i == 0) {
					result.add(i);
					if (Math.sqrt(A) != i) {
						result.add(A / i);
					}
				}

			}

			result = (ArrayList<Integer>) result.parallelStream().sorted().collect(Collectors.toList());
		}
		return result;	
	}
}
