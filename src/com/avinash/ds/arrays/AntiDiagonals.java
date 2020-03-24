package com.avinash.ds.arrays;

import java.util.ArrayList;

public class AntiDiagonals {

	public static void main(String[] args) {
		ArrayList<Integer> arr1 = new ArrayList<>();
		arr1.add(1);
		arr1.add(2);
		arr1.add(3);
		
		ArrayList<Integer> arr2 = new ArrayList<>();
		arr2.add(4);
		arr2.add(5);
		arr2.add(6);
		
		ArrayList<Integer> arr3 = new ArrayList<>();
		arr3.add(7);
		arr3.add(8);
		arr3.add(9);
		
		ArrayList<ArrayList<Integer>> input = new ArrayList<>();
		input.add(arr1);
		input.add(arr2);
		input.add(arr3);
		
		System.out.println(diagonal(input));
	}

	public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		int endIndex = 0;
		for (int i = 0; i < A.size(); i++) {
			for (int j = endIndex; j < A.size(); j++) {
				ArrayList<Integer> diagonal = new ArrayList<>();
				int columnIterator = j;
				int rowIterator = i;
				do {
					diagonal.add(A.get(rowIterator).get(columnIterator));
					columnIterator--;
					rowIterator++;
				} while (columnIterator >= 0 && rowIterator < A.size());
				result.add(diagonal);
			}
			endIndex = A.size()-1;
		}
		return result;
	}
}
