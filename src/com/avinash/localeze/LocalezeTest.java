//package com.avinash.localeze;
//import java.util.concurrent.CompletableFuture;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//import TARGUSinfo.api.ClientAPI;
//
//public class LocalezeTest {
//
//	private static final ExecutorService localezeExecutor = Executors.newFixedThreadPool(1);
//	
//	public static void main(String[] args) throws Exception {
//		setupLocalezeClient();
//	}
//
//	private static void setupLocalezeClient() throws Exception{
//		ClientAPI localezeClient = new ClientAPI();
//		
//		localezeClient.configure(LocalezeTest.class.getResource("localeze.properties").toString());
//		localezeClient.createHandlerThreads(1);
//		
//		CompletableFuture.runAsync(localezeClient, localezeExecutor);
//		int time =0;
//		while(localezeClient.inServiceCount() <= 0) {
//			System.out.println("times"+(++time));
//			Thread.sleep(50);
//		}
//		
//		System.out.println("Client is setup "+localezeClient.inServiceCount());
//		localezeClient.stop();
//		
//	}
//}
//
