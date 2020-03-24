package com.avinash.ds.math;

import java.util.ArrayList;

public class Sieve {

	public static void main(String[] args) {
		System.out.println(sieve(15));
	}

	public static ArrayList<Integer> sieve(int A) {
		ArrayList<Integer> result = new ArrayList<>();

		boolean[] isPrimes = new boolean[A+1]; 
		
		for (int i = 2; i <= A; i++) {
			if(!isPrimes[i]) {
				for(int j=2;j*i<=A;j++) {
					isPrimes[j*i]=true;
				}
			}
		}
		
		for(int i=2;i<=A;i++) {
			if(!isPrimes[i]) {
				result.add(i);
			}
			
		}
		return result;
	}
	
}
