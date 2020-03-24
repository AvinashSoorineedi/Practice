package com.avinash.completable.future.demo;

import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class JobWithCompletableFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		System.out.println("Start time is " + new Timestamp(new Date().getTime()));
		CompletableFuture<String> future = new CompletableFuture<>();
		for (int i = 0; i < 500; i++) {
			WaitJob waitJob = new WaitJob();
			future = waitJob.getResponseWithWaitCompletableFuture();

		}
		future.get();
		System.out.println("End time is " + new Timestamp(new Date().getTime()));

	}

}
