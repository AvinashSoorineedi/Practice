package com.avinash.bridge.pattern;

public class Square extends Shape {

	public Square(Color color) {
		super(color);
	}
	
	@Override
	public String draw() {
		return "square shape is "+color.fill();
	}

	
}
