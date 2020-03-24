package com.avinash.decorator.pattern;

public class PizzaDecorator implements Pizza{

	Pizza pizza;
	
	public PizzaDecorator(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public void make() {
		pizza.make();
	}
	
}
