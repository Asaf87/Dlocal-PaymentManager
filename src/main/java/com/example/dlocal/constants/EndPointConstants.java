package com.example.dlocal.constants;

public class EndPointConstants {

	public static final String API_BASE_ENDPOINT = "http://data.fixer.io/api/";

	public static final String LATEST = "latest?";

	public static final String ACCESS_KEY = "access_key=6e9be5fce797eebe7b4bda9ff0cf8e9f";

	public static final String BASE = "&base=EUR";

	public static final String SYMBOLS = "&symbols";

	public static final String GET_RATES_QUERY = API_BASE_ENDPOINT + LATEST
			+ ACCESS_KEY + BASE;
}
