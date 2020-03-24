package com.avinash.decorator.pattern;

public class NonVegSupremePizza extends PizzaDecorator{

	public NonVegSupremePizza(Pizza pizza) {
		super(pizza);
	}

	@Override
	public void make() {
		super.make();
		System.out.println("Created Non Veg Toppings");
	}
	
}
