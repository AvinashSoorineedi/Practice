package com.avinash.transform;

import java.util.Objects;
import java.util.function.Function;

public class BaseTransformer {

	public static Function<Source, String> nameTransfomer(){
		return s -> {
			return s.getName();
		};
		
	}
	
	public static Function<String, String> checkMandatory(){
		return o -> {
			if(o==null || Objects.isNull(o)) {
				throw new RuntimeException();
			}
			return o;
		};
	}
}
