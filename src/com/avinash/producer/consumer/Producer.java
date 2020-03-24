package com.avinash.producer.consumer;

import java.util.List;
import java.util.Random;

public class Producer implements Runnable {

	private List<Integer> list;
	private Object obj;

	public Producer(List<Integer> list, Object obj) {
		this.list = list;
		this.obj = obj;
	}

	@Override
	public void run() {

		while (true) {
			synchronized (obj) {
				if (list.size() > 5) {
					try {
						obj.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				Random random = new Random();
				int val = random.nextInt();
				System.out.println("Producer created " + val);
				list.add(val);
				obj.notifyAll();
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}

}
