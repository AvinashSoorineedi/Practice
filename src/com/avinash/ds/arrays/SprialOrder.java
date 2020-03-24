package com.avinash.ds.arrays;

import java.util.ArrayList;
import java.util.List;

public class SprialOrder {

	public static void main(String[] args) {

		int ar1[] = new int[] {133, 241, 22, 258, 187, 150, 79, 207, 196, 401, 366, 335, 198};
		int ar2[] =new int[] {401, 55, 260, 363, 14, 318, 178, 296, 333, 296, 45, 37, 10};
		int ar3[] = new int[] {112, 374, 79, 12, 97, 39, 310, 223, 139, 91, 171, 95, 126};

//		int ar1[] = new int[] { 75, 371 };
//		int ar2[] = new int[] { 230, 201 };
//		int ar3[] = new int[] { 58, 72 };
//		int ar4[] = new int[] { 128, 166 };
//		int ar5[] = new int[] { 198, 225 };
//		int ar6[] = new int[] { 170, 173 };
//		int ar7[] = new int[] { 401, 77 };
//		int ar8[] = new int[] { 229, 17 };
//		int ar9[] = new int[] { 304, 50 };

//		int ar1[] = new int[] {1,2,3,4};
//		int ar2[] =new int[] {5,6,7,8};
//		int ar3[] = new int[] {9,10,11,12};
//		int ar4[] = new int[] {13,14,15,16};
//
//		int ar1[] = new int[] {1};
//		int ar2[] =new int[] {2};
//		int ar3[] = new int[] {3};

		List<ArrayList<Integer>> arr = new ArrayList<>();
		ArrayList<Integer> arr1 = new ArrayList<>();

		for (Integer i : ar1) {
			arr1.add(i);
		}


		ArrayList<Integer> arr2 = new ArrayList<>();

		for (Integer i : ar2) {
			arr2.add(i);
		}
		ArrayList<Integer> arr3 = new ArrayList<>();

		for (Integer i : ar3) {
			arr3.add(i);
		}
//		ArrayList<Integer> arr4 = new ArrayList<>();
//		for (Integer i : ar4) {
//			arr4.add(i);
//		}

//		ArrayList<Integer> arr5 = new ArrayList<>();
//		for (Integer i : ar5) {
//			arr5.add(i);
//		}
//		ArrayList<Integer> arr6 = new ArrayList<>();
//		for (Integer i : ar6) {
//			arr6.add(i);
//		}
//		ArrayList<Integer> arr7 = new ArrayList<>();
//		for (Integer i : ar7) {
//			arr7.add(i);
//		}
//		ArrayList<Integer> arr8 = new ArrayList<>();
//		for (Integer i : ar8) {
//			arr8.add(i);
//		}
//		ArrayList<Integer> arr9 = new ArrayList<>();
//		for (Integer i : ar9) {
//			arr9.add(i);
//		}
		arr.add(arr1);
		arr.add(arr2);
		arr.add(arr3);
	   // arr.add(arr4);
//		arr.add(arr5);
//		arr.add(arr6);
//		arr.add(arr7);
//		arr.add(arr8);
//		arr.add(arr9);
		System.out.println(spiralOrder(arr));

	}

	public static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		int left = 0, right = a.get(0).size(), top = 0, bottom = a.size();

		while (left < right && top < bottom) {

			for (int i = left; i < right; i++) {
				result.add(a.get(top).get(i));
			}
			top++;

			for (int i = top; i < bottom; i++) {
				result.add(a.get(i).get(right - 1));
			}
			right--;

			if (left < right && top<bottom) {
				for (int i = right - 1; i >= left; i--) {
					result.add(a.get(bottom - 1).get(i));
				}
				bottom--;
			}

			if (top < bottom && left < right) {
				for (int i = bottom - 1; i >= top; i--) {
					result.add(a.get(i).get(left));
				}
				left++;
			}
		}
		return result;
	}
}
