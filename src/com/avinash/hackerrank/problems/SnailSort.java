package com.avinash.hackerrank.problems;

import java.util.Arrays;

public class SnailSort {

	public static void main(String[] args) {

		int[][] array = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };

		int[][] array1 = { { 1, 2, 3, 4 },
		                   { 12, 13, 14, 5 },
		                   { 11, 16, 15, 6 },
		                   { 10, 9, 8, 7 }};
		
		int[][] array2 = {{1,2,3,4,5},
						  {16,17,18,19,6},
						  {15,24,25,20,7},
						  {14,23,22,21,8},
						  {13,12,11,10,9}};
		
		int[][] nullarr = {{}};
		
		System.out.println(nullarr.length);
		int res[] = snailSort(nullarr,nullarr.length);
		
//		for(Integer i: res) {
//			System.out.println(i);
//		}
		System.out.println(Arrays.toString(res));
	}

	private static int[] snailSort(int[][] arr, int n) {

		int[] finalArr = new int[n*n];
		
			int firstRow = 0, firstColumn = 0, lastRow = n - 1, lastColumn = n - 1;

			int k = 0;

			while (firstRow <= lastRow) {
				for (int i = firstColumn; i < lastColumn; i++) {
					finalArr[k] = arr[firstRow][i];
					k++;
				}

				for (int i = firstRow; i < lastRow; i++) {
					finalArr[k] = arr[i][lastColumn];
					k++;
				}

				for (int i = lastColumn; i > firstColumn; i--) {
					finalArr[k] = arr[lastRow][i];
					k++;
				}

				for (int i = lastRow; i > firstColumn; i--) {
					finalArr[k] = arr[i][firstColumn];
					k++;
				}

				firstRow++;
				lastColumn--;
				lastRow--;
				firstColumn++;
			}

			try {
			if (n % 2 != 0) {
				finalArr[k] = arr[n / 2][n / 2];
			}
			}catch(Exception e) {
				return new int[0];
			}
		
		
		return finalArr;
	}

}
