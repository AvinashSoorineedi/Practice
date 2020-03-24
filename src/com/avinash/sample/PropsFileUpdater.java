package com.avinash.sample;

import java.util.Random;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;


public class PropsFileUpdater implements Runnable {

//	private String username;
//	private String password;
//
//	public PropsFileUpdater(String username, String password) {
//		this.username = username;
//		this.password = password;
//	}

	@Override
	public void run() {
		PropertiesConfiguration props;
		try {
			
			Random random = new Random();
			int a = random.nextInt(100);
			int b = a;
			
			props = new PropertiesConfiguration("localeze.properties");
			props.setProperty("Protocol.1.username", a);
			props.setProperty("Protocol.1.password", b);
			props.save();

		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
