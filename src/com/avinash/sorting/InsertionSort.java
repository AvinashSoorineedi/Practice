package com.avinash.sorting;

public class InsertionSort {

	public static void main(String args[]) {

		int[] inputArr = { 1, 5, 8, 3, 10, 2, 31, 11, 19, 4 };
		System.out.println("Before Array sorting");
		SortingUtil.printArr(inputArr);

		insertionSort(inputArr);

		System.out.println();
		System.out.println();
		
		System.out.println("After Array sorting");
		SortingUtil.printArr(inputArr);
	}

	private static void insertionSort(int[] inArr) {
		for (int i = 1; i < inArr.length; i++) {
			for (int j = i; j > 0; j--) {
				if(inArr[j] < inArr[j-1]) {
					SortingUtil.swap(inArr, j, j-1);
				}
			}
		}
	}
}
