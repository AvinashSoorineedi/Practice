package com.avinash.completable.future.demo;

import java.sql.Timestamp;
import java.util.Date;

public class JobWithoutCompletableFuture {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Start time is " + new Timestamp(new Date().getTime()));

		for (int i = 0; i < 10000; i++) {
			WaitJob waitJob = new WaitJob();
			waitJob.getResponseWithWait();
		}

		System.out.println("End time is " + new Timestamp(new Date().getTime()));
	}

}
