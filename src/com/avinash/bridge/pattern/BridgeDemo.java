package com.avinash.bridge.pattern;

public class BridgeDemo {

	public static void main(String[] args) {
		try {
		Shape square = new Square(new RedColor());
		
		System.out.println(square.draw());
		
			Thread.sleep(10);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
