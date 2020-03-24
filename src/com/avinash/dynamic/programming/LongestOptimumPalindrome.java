package com.avinash.dynamic.programming;

public class LongestOptimumPalindrome {

	public static void main(String[] args) {
		
		String s = "aaa";
		
		printLongestPalindrome(s);

	}

	private static void printLongestPalindrome(String s) {
		
		int maxPalindromeSize =0;
		int startIndex =0;
		int endIndex=0;
		
		for(int i=0;i<s.length();i++) {
			if(palindrome(s, i)) {
				
			}
		}
		
	}

	private static boolean palindrome(String s, int i) {
		// TODO Auto-generated method stub
		return false;
	}

}
