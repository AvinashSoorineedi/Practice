package com.avinash.producer.consumer;

import java.util.List;

public class Consumer implements Runnable {

	private List<Integer> list;
	private Object obj;

	public Consumer(List<Integer> list, Object obj) {
		this.list = list;
		this.obj = obj;
	}

	@Override
	public void run() {

		while (true) {
			synchronized (obj) {

				if (list.size() == 0) {
					obj.notify();
					try {
						obj.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

					System.out.println("Consumer removing " + list.get(0));
					list.remove(0);

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
