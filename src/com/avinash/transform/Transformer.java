package com.avinash.transform;

import java.util.function.Function;

public class Transformer extends BaseTransformer{

	static Function<Source, Destination> destination = new Function<Source, Destination>() {
		
		@Override
		public Destination apply(Source t) {
			Destination destination = new Destination();
			
			//with mandatory
			destination.setMyName(checkMandatory().apply(nameTransfomer().apply(t)));
			
			//without mandatory
			destination.setMyName(nameTransfomer().apply(t));	
			
			return destination;
		}
	};
	
}
