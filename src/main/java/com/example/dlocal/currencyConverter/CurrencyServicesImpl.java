package com.example.dlocal.currencyConverter;

import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dlocal.businessExceptions.NotExistCurrencyException;
import com.example.dlocal.constants.Currency;
import com.example.dlocal.constants.EndPointConstants;
import com.example.dlocal.servicesInterfaces.CurrencyServices;

@Component
public class CurrencyServicesImpl implements CurrencyServices {

	@Autowired
	ApiLastRatesRequest request;

	@Override
	public Double getAmountInUsd(String fromCurrency, Double amount) {

		if (!EnumUtils.isValidEnum(Currency.class, fromCurrency)) {
			throw new NotExistCurrencyException();
		}

		// ApiResponse is in Cache, once the data written in cache,it will
		// expire after 30 seconds
		ApiLastRatesResponse res = request
				.getResponse(EndPointConstants.GET_RATES_QUERY);

		// get the rate of EURO->USD since the free API plan allow only EUR as//
		// base currency.
		Double usdRate = res.getRates().get(Currency.USD);

		// get the supplied currency Rate
		Double fromCurrencyRate = res.getRates().get(
				Currency.valueOf(fromCurrency));

		// the Conversion will be from supplied Currency to ->EURO->USD.
		return amount / (fromCurrencyRate / usdRate);
	}
}
