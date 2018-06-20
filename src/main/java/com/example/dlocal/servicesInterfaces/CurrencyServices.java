package com.example.dlocal.servicesInterfaces;

/*
 * Internal interface.
 */
public interface CurrencyServices {

	/**
	 * Get the amount of selected currency in USD.
	 */
	public Double getAmountInUsd(String currency, Double amount);
}
