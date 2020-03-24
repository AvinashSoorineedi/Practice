package com.avinash.ds.arrays;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class WaveArray {

	public static void main(String[] args) {

		ArrayList<Integer> l = new ArrayList<>();
		l.add(4);
		l.add(2);
		l.add(3);
		l.add(1);
		l.add(5);
		l.add(6);
		System.out.println(wave(l));
	}

	public static ArrayList<Integer> wave(ArrayList<Integer> A) {
		A = (ArrayList<Integer>) A.parallelStream().sorted().collect(Collectors.toList());

		for (int i = 0; i < A.size()-1; i = i + 2) {
			int temp = A.get(i);
			A.set(i, A.get(i + 1));
			A.set(i + 1, temp);
		}
		return A;
	}
}
