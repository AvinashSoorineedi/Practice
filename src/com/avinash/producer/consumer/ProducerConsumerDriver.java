package com.avinash.producer.consumer;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerDriver {

	public static void main(String[] args) throws InterruptedException {
		
		List<Integer> list = new ArrayList<Integer>();
		
		ProducerConsumerDriver obj = new ProducerConsumerDriver();
		
		Thread producer = new Thread(new Producer(list, obj));
		Thread consumer = new Thread(new Consumer(list, obj));
		
		producer.start();
		consumer.start();
		

	}

}
