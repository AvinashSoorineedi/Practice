package com.avinash.completable.future.demo;

import java.util.concurrent.CompletableFuture;

public class WaitJob {

	public String getResponseWithWait() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Response";
	}
	
	public CompletableFuture<String> getResponseWithWaitCompletableFuture() {
		
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Response";
		});
		
		return future;
	}
}
