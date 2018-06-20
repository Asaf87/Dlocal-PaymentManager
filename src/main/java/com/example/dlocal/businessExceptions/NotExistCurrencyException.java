package com.example.dlocal.businessExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "The requested currency isn't supported")
public class NotExistCurrencyException extends WrongBusinessLogicException {

	private static final long serialVersionUID = 1L;

	private static final String CURRENCY_NOT_EXIST = "The supplied currency not exist";

	public NotExistCurrencyException() {
		super(CURRENCY_NOT_EXIST);
	}
}
