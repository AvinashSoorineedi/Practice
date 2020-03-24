package com.avinash.ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {

	public static void main(String[] args) {

		List<Integer> l = new ArrayList<Integer>();
		l.add(3);
		l.add(30);
		l.add(34);
		l.add(5);
		l.add(9);

		System.out.println(largestNumber(l));
	}

	public static String largestNumber(final List<Integer> A) {
		StringBuffer sb = new StringBuffer();
		String[] arr = new String[A.size()];
		int k = 0;
		for (int n : A) {
			arr[k] = String.valueOf(n);
			k++;
		}

		Arrays.sort(arr, new Comparator<String>() {
			public int compare(String a, String b) {
				return (b + a).compareTo(a + b);
			}
		});

		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}
		if(sb.charAt(0)=='0') {
			return String.valueOf(0);
		}
		return sb.toString();
	}

}
