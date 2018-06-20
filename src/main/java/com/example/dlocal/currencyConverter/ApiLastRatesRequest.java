package com.example.dlocal.currencyConverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

//import org.json.JSONObject;
import com.example.dlocal.businessExceptions.InternalErrorException;

//import com.google.gson.Gson;

@Component
public class ApiLastRatesRequest {

	public URL url;

	/**
	 * Get the currency rates from Fixer.io. While reading the response, use
	 * buffer to stream the data The method annotated with Cacheable in order to
	 * store it in cache for 30 seconds
	 * 
	 * @param endpoint
	 * @return
	 * @throws InternalErrorException
	 */
	@Cacheable("ApiResponseCache")
	public ApiLastRatesResponse getResponse(String endpoint)
			throws InternalErrorException {
		ApiLastRatesResponse resp = null;
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferReader = null;

		try {
			URL url = new URL(endpoint);
			bufferReader = new BufferedReader(new InputStreamReader(
					url.openStream()));
			JSONObject jsonObj = null;

			int data = bufferReader.read();
			while (data != -1) {
				stringBuilder.append((char) data);
				data = bufferReader.read();
			}
			bufferReader.close();

			try {
				jsonObj = new JSONObject(stringBuilder.toString());
			} catch (JSONException e) {
				throw new InternalErrorException();
			}

			// parse the json to object
			resp = new ApiLastRatesResponse(jsonObj);

		} catch (IOException e) {
			throw new InternalErrorException();
		}
		return resp;
	}
}
