package com.avinash.elastic.stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class ElasticStackTest {

	private static Logger logger = LoggerFactory.getLogger(ElasticStackTest.class);
			
	public static void main(String[] args) {
		
		MDC.put("es_index", "sample-test-index-1");
		MDC.put("Stack", "mystack");
		logger.info("My Last Name is: {}", "Avinash");
		logger.info("My First Name is: {}", "Ram");
		MDC.remove("Stack");
		
		MDC.put("Stack2", "mystack2");
		logger.info("Test Second MDC: {}", "working");
		
		MDC.remove("Stack2");
		
		MDC.put("es_index", "sample-test-index-2");
		logger.info("Sample Index testing");

	}

}
