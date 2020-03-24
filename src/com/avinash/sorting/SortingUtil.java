package com.avinash.sorting;

public class SortingUtil {

	public static void printArr(int[] inArr) {
		for(int each:inArr) {
			System.out.print(each + " ");
		}
	}
	
	public static void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
}
