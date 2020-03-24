package com.localeze.curl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import com.opencsv.CSVReader;

public class LocalezeCurlExecutor {

	public static void main(String[] args) {

		CSVReader csvReader = null;
		try {
			FileReader fileReader = null;
			try {
				URL filePath = LocalezeCurlExecutor.class.getResource("localezecurl.csv");
				fileReader = new FileReader(filePath.getFile());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			csvReader = new CSVReader(fileReader);

			String[] nextRecord;

			while ((nextRecord = csvReader.readNext()) != null) {

				String tenantID = nextRecord[0];
				String locationUid = nextRecord[1];

				String[] command = { "curl", "-v", "-H", "Content-Type: application/json", "-d",
						"{\n" + "    \"requestHeader\": {\n" + "        \"agencyID\": 1,\n" + "        \"tenantID\": "
								+ tenantID + ",\n" + "        \"userID\": 1,\n" + "        \"loggedTenantID\": 1,\n"
								+ "        \"loggedUserID\": 1\n" + "    },\n" + "    \"locationUid\": " + locationUid
								+ ",\n" + "    \"sourceID\":\"LOCALEZE\",\n" + "    \"credentialID\": null,\n"
								+ "    \"credentialAccountID\": null\n" + "}",
						"http://qa-profile-publish01.r4e-qa.reputation.ec2:29325/rest2thrift/R4EProfilePublish/enqueuePublishJobSync" };

				ProcessBuilder process = new ProcessBuilder(command);
				process.start();

				Thread.sleep(10);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				csvReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
