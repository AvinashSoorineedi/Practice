package com.avinash.sorting;

public class SelectionSort {

	public static void main(String args[]) {
		int[] inputArr = { 1, 5, 8, 3, 10, 2, 31, 11, 19, 4 };
		System.out.println("Before Array sorting");
		SortingUtil.printArr(inputArr);

		selectionSort(inputArr);

		System.out.println();
		System.out.println();

		System.out.println("After Array sorting");
		SortingUtil.printArr(inputArr);
	}

	private static void selectionSort(int[] inArr) {

		for (int i = 0; i < inArr.length; i++) {
			int maxIndex = 0;
			for (int j = 0; j < (inArr.length - i); j++) {
				if (inArr[j] > inArr[maxIndex]) {
					maxIndex = j;
				}
			}
			SortingUtil.swap(inArr, maxIndex, (inArr.length - i - 1));
		}
	}
}
