package com.avinash.decorator.pattern;

public class VegSupremePizza extends PizzaDecorator{

	public VegSupremePizza(Pizza pizza) {
		super(pizza);
	}

	@Override
	public void make() {
		super.make();
		System.out.println("Created Veg toppings");
	}
	
}
