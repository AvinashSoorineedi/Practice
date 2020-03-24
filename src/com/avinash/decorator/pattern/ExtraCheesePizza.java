package com.avinash.decorator.pattern;

public class ExtraCheesePizza extends PizzaDecorator{

	public ExtraCheesePizza(Pizza pizza) {
		super(pizza);
	}

	@Override
	public void make() {
		super.make();
		System.out.println("Added Extra Cheese");
	}
}
