package com.avinash.sample;

public interface SecondInterface {

	default String getName() {
		return "Second Name";
	}
}
