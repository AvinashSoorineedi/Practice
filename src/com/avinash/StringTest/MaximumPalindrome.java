package com.avinash.StringTest;

public class MaximumPalindrome {

	public static void main(String[] args) {

		char[] result = showMaximumPalindrome("bb");
		if(result.length>0) {
			System.out.println(result);
		}else {
			System.out.println("No Palindrome Found");
		}
		
	}

	private static char[] showMaximumPalindrome(String A) {

		int palindromeSize = 0;
		int left = 0;
		int right = 0;

		if (A == null || A.length() == 1) {

		} else {
			for (int i = 0; i < A.length(); i++) {
				for (int j = i + 1; j < A.length(); j++) {
					boolean checkForPalindrome;
					if (A.charAt(i) == A.charAt(j)) {
						checkForPalindrome = checkForLargestPalindrome(A, i, j);
						if (checkForPalindrome) {
							if ((j - i) > palindromeSize) {
								palindromeSize = (j - i);
								left = i;
								right = j;
							}
						}
					}

				}
			}

		}
		return A.substring(left, right + 1).toCharArray();
	}

	private static boolean checkForLargestPalindrome(String string, int i, int j) {
		char[] palindromeseq = string.substring(i, j + 1).toCharArray();

		for (int k = 0; k < (palindromeseq.length) / 2; k++) {
			if (palindromeseq[k] != palindromeseq[(palindromeseq.length - 1) - k]) {
				return false;
			}
		}

		return true;
	}

}
