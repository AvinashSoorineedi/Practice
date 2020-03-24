package com.avinash.decorator.pattern;

public class PizzaCreator {

	public static void main(String[] args) {

		Pizza vegSupremePizza = new VegSupremePizza(new BasePizza());
		Pizza nonVegSupremePizza = new NonVegSupremePizza(new ExtraCheesePizza(new BasePizza()));

		vegSupremePizza.make();
		nonVegSupremePizza.make();

	}

}
