package com.avinash.ds.math;

public class VerifyPrime {

	public static void main(String[] args) {
		System.out.println(isPrime(6));
	}

	public static int isPrime(int A) {
		int isPrime = 1;
		for (int i = 2; i <= Math.sqrt(A); i++) {
			if(A%i==0) {
				isPrime = 0;
			}
		}
		return isPrime;
	}

}
