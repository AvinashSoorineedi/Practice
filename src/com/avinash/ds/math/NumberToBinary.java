package com.avinash.ds.math;

import java.util.ArrayList;
import java.util.List;

public class NumberToBinary {

	public static void main(String[] args) {
		System.out.println(findDigitsInBinary(6));
	}

	public static String findDigitsInBinary(int A) {

		List<Integer> list = new ArrayList<Integer>();

		StringBuffer sb = new StringBuffer();
		while (A > 0) {
			list.add(A % 2);
			A = A / 2;
		}

		for (int i = list.size() - 1; i >= 0; i--) {
			sb.append(list.get(i));
		}

		return sb.toString();
	}

}
