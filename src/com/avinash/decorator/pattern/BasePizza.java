package com.avinash.decorator.pattern;

public class BasePizza implements Pizza{

	@Override
	public void make() {
		System.out.println("Created Pizza Base");
	}
}
