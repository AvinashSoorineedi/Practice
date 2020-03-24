package com.avinash.bridge.pattern;

public abstract class Shape {
	public abstract String draw();
	protected Color color;

	public Shape(Color color) {
		this.color = color;
	}
}
