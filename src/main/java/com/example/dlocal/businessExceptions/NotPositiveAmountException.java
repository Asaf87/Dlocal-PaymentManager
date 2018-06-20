package com.example.dlocal.businessExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "The supplied amount is not positive")
public class NotPositiveAmountException extends WrongBusinessLogicException {

	private static final long serialVersionUID = 1L;

	private static final String NOT_POSITIVE_AMOUNT = "The supplied amount is not positive";

	public NotPositiveAmountException() {
		super(NOT_POSITIVE_AMOUNT);
	}

}
