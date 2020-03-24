package com.avinash.ds.arrays;

import java.util.ArrayList;
import java.util.Stack;

public class MaxProductOfIndexes {

	public static void main(String args[]) {

		ArrayList<Integer> a = new ArrayList<>();
		a.add(5);
		a.add(9);
		a.add(6);
		a.add(8);
		a.add(6);

		a.add(4);
		a.add(6);
		a.add(9);
		a.add(5);
		a.add(4);

		a.add(9);
		System.out.println(maxSpecialProduct(a));
	}

	public static int maxSpecialProduct(ArrayList<Integer> A) {
		ArrayList<Integer> l = leftSpecialV(A);
		ArrayList<Integer> r = rightSpecialV(A);

		long product = 0, res = 0;

		for (int i = 0; i < A.size(); i++) {
			res = (long) l.get(i) * (long) r.get(i);
			if (product < res) {
				product = res;
			}
		}

		return (int) (product % 1000000007);
	}

	private static ArrayList<Integer> leftSpecialV(ArrayList<Integer> A) {

		ArrayList<Integer> r = new ArrayList<>();
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < A.size(); i++) {
			while (!s.empty() && A.get(s.peek()) <= A.get(i)) {
				s.pop();
			}

			if (s.empty()) {
				r.add(0);
			} else {
				r.add(s.peek());
			}
			s.push(i);
		}

		return r;
	}

	private static ArrayList<Integer> rightSpecialV(ArrayList<Integer> A) {

		ArrayList<Integer> r = new ArrayList<>();
		Stack<Integer> s = new Stack<>();
		for (int i = A.size() - 1; i >= 0; i--) {
			while (!s.empty() && A.get(s.peek()) <= A.get(i)) {
				s.pop();
			}

			if (s.empty()) {
				r.add(0, 0);
			} else {
				r.add(0, s.peek());
			}
			s.push(i);
		}

		return r;
	}
}
