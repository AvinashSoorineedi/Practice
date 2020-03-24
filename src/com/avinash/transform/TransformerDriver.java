package com.avinash.transform;

public class TransformerDriver {

	public static void main(String[] args) {
		
		Source source = new Source();
		source.setName(null);
		source.setColor("Blue");
		source.setAge(20);
		
		System.out.println("Source is "+source.toString());
		
		System.out.println("Destination is"+Transformer.destination.apply(source));

	}
	
	

}
