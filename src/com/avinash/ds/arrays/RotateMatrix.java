package com.avinash.ds.arrays;

import java.util.ArrayList;

public class RotateMatrix {

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(1);
		a1.add(2);

		ArrayList<Integer> a2 = new ArrayList<Integer>();
		a2.add(3);
		a2.add(4);

		a.add(a1);
		a.add(a2);
		rotate(a);
	}

	public static void rotate(ArrayList<ArrayList<Integer>> a) {
		if (!a.isEmpty()) {

			ArrayList<ArrayList<Integer>> result = new ArrayList<>();
			for (int i = 0; i < a.size(); i++) {
				ArrayList<Integer> temp = new ArrayList<>();
				for (int j = a.size() - 1; j >= 0; j--) {
					temp.add(a.get(j).get(i));
				}
				result.add(temp);
			}
			int size = a.size();
			for (int i = 0; i < size; i++) {
				a.remove(0);
			}
			a.addAll(result);
		}
	}
}
