package com.avinash.StringTest;

public class StringTest {

	public static void main(String[] args) {

		String s1 = new String("Hello");

		String s2 = "Hello";

		System.out.println("s1 hashcode: " + s1.hashCode());
		System.out.println("s2 hashcode: " + s2.hashCode());
		System.out.println("Is s1==s2: " + (s1 == s2));

	}

}
