package com.avinash.StringTest;

public class StringCombinations {

	public static void main(String[] args) {

		showCombinations("abc");

	}

	private static void showCombinations(String str) {

		helper(str, new String());
	}

	private static void helper(String given, String choosen) {
		if (given.isEmpty()) {
			System.out.println(choosen);
		} else {
			for (int i = 0; i < given.length(); i++) {
				helper(given.substring(0, i) + given.substring(i+1, given.length()), choosen + given.charAt(i));
			}
		}

	}

}
