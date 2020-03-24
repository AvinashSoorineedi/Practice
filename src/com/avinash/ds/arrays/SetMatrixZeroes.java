package com.avinash.ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SetMatrixZeroes {

	public static void main(String[] args) {

//		Integer[] arr1 = { 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0,
//				0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1 };
//		Integer[] arr2 = { 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0,
//				1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0 };
//		Integer[] arr3 = { 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1,
//				0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1 };
//		Integer[] arr4 = { 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1,
//				1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1 };
//		Integer[] arr5 = { 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0,
//				1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1 };
//		Integer[] arr6 = { 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1,
//				1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1 };
//		Integer[] arr7 = { 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1,
//				0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1 };
//		Integer[] arr8 = { 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0,
//				1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1 };
		
		Integer[] arr1 = {0,0};
		Integer[] arr2 = {1,1};

		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		ArrayList<Integer> list3 = new ArrayList<>();
		list1.add(1);
		list1.add(0);
		list1.add(1);

		list2.add(0);
		list2.add(1);
		list2.add(1);

		list3.add(1);
		list3.add(1);
		list3.add(1);

		List<List<Integer>> input = new ArrayList<>();

		input.add(Arrays.asList(arr1));
		input.add(Arrays.asList(arr2));
//		input.add(Arrays.asList(arr3));
//		input.add(Arrays.asList(arr4));
//		input.add(Arrays.asList(arr5));
//		input.add(Arrays.asList(arr6));
//		input.add(Arrays.asList(arr7));
//		input.add(Arrays.asList(arr8));
//		input.add(list2);
//		input.add(list3);

		setZeroes(input);

	}

	public static void setZeroes(List<List<Integer>> a) {

		List<Integer> excludedRows = new ArrayList<>();
		List<Integer> excludedColumns = new ArrayList<>();

		for (int i = 0; i < a.size(); i++) {
			if (excludedRows.contains(i)) {
				continue;
			}
			for (int j = 0; j < a.get(i).size(); j++) {
				if (excludedColumns.contains(j) && a.get(i).get(j) == 0) {
					if (!excludedRows.contains(i)) {
						excludedRows.add(i);
					}
					continue;
				}
				if (a.get(i).get(j) == 0) {
					if (!excludedRows.contains(i)) {
						excludedRows.add(i);
					}
					if (!excludedColumns.contains(j)) {
						excludedColumns.add(j);
					}
				}
			}
		}

		Collections.sort(excludedRows);
		Collections.sort(excludedColumns);

		for (int i = 0; i < excludedRows.size(); i++) {
			for (int j = 0; j < a.get(i).size(); j++) {
				a.get(excludedRows.get(i)).set(j, 0);
			}
		}

		for (int i = 0; i < a.size(); i++) {
			for (int j = 0; j < excludedColumns.size(); j++) {
				a.get(i).set(excludedColumns.get(j), 0);
			}
		}

	}
}
