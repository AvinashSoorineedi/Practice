package com.avinash.ds.arrays;

import java.util.ArrayList;

public class MinStepsInInfinityGrid {

	public static void main(String[] args) {

		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Integer> b = new ArrayList<>();
		a.add(1);
		a.add(2);
		a.add(6);
		b.add(1);
		b.add(2);
		b.add(6);

		System.out.println(coverPoints(a, b));

	}

	public static int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
		int result = 0;

		for (int i = 0; i < A.size()-1; i++) {
			int x = A.get(i);
			int y = B.get(i);
			int expectedX = A.get(i+1);
			int expectedY = B.get(i+1);
			
			result+=Math.max(Math.abs(x-expectedX), Math.abs(y-expectedY));
		}

		return result;
	}
}
