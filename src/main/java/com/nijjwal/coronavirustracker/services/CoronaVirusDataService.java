package com.nijjwal.coronavirustracker.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
/**
 * @Service tells Spring Framework to create an instance of a class.
 * @author Nijjwal
 *
 */
public class CoronaVirusDataService {

	private static String US_VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_US.csv";

	@PostConstruct
	/**
	 * @PostConstruct annotation tells Spring, after you construct instance of this
	 *                service execute this method.
	 * @throws IOException
	 */
	public void fetchVirusData() throws IOException {

		// 1. Create URL
		URL url = new URL(US_VIRUS_DATA_URL);

		// 2. Create connection object and establish connection
		HttpURLConnection connObjOnly = (HttpURLConnection) url.openConnection();
		connObjOnly.setRequestMethod("GET");

		/*
		 * 3. Execute the request using getResponseCode(), connect(), getInputStream()
		 * or getOutputStream() methods.
		 */
		int responseCode = connObjOnly.getResponseCode();
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(connObjOnly.getInputStream()));

		// 4. Read the response of the request and put it in a Content String
		String inputLine;
		StringBuffer content = new StringBuffer();
		while ((inputLine = inputReader.readLine()) != null) {
			content.append(inputLine);
			content.append("\n");
		}
		inputReader.close();

		// 3. Close the connection using disconnect() method
		connObjOnly.disconnect();

		/*
		 * 4. Print the response in the console. Note: By default console won't print
		 * everything if there is a lot of data. Adjust your console setting accordingly
		 * if you want to print everything on the console.
		 */
		System.out.println("Response from JHU:");
		System.out.println(content);
		System.out.println("Response Code is: " + responseCode);
	}
}
