package com.example.dlocal.currencyConverter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.EnumUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.dlocal.businessExceptions.InternalErrorException;
import com.example.dlocal.constants.Currency;

public final class ApiLastRatesResponse {

	private boolean success;

	private Integer unixTimestamp;

	private Currency base;

	private Date date;

	private Map<Currency, Double> rates;

	public ApiLastRatesResponse() {
	}

	public ApiLastRatesResponse(JSONObject jsonResponse) {
		try {
			setSuccess((Boolean) jsonResponse.get("success"));
			setUnixTimestamp((Integer) jsonResponse.get("timestamp"));
			setBase((String) jsonResponse.get("base"));
			setRates(jsonResponse.getJSONObject("rates"));
		} catch (JSONException e) {
			throw new InternalErrorException();
		}
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Integer getUnixTimestamp() {
		return unixTimestamp;
	}

	public void setUnixTimestamp(Integer timestamp) {
		this.unixTimestamp = timestamp;
	}

	public Currency getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = Currency.valueOf(base);
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Map<Currency, Double> getRates() {
		return rates;
	}

	/**
	 * Build the Rates Map from response
	 */
	public void setRates(JSONObject jsonObj) {
		try {
			this.rates = new HashMap<>();
			for (int i = 0; i < jsonObj.names().length(); i++) {
				String currencyAsString = jsonObj.names().getString(i);
				Double rate = jsonObj.getDouble(currencyAsString);
				if (EnumUtils.isValidEnum(Currency.class, currencyAsString)) {
					Currency currency = Currency.valueOf(currencyAsString);
					this.rates.put(currency, rate);
				}
			}
		} catch (JSONException e) {
			throw new InternalErrorException();
		}
	}

}
