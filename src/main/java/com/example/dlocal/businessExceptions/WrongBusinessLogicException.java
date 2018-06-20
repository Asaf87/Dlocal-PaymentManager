package com.example.dlocal.businessExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class WrongBusinessLogicException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private static final String WRONG_BUSINESS = "Wrong Businees logic: ";

	private String exceptionDesc;

	public WrongBusinessLogicException(String exceptionDesc) {
		super(WRONG_BUSINESS.concat(exceptionDesc));
		this.exceptionDesc = WRONG_BUSINESS.concat(exceptionDesc);
	}

	public String getExceptionDesc() {
		return exceptionDesc;
	}

	public void setExceptionDesc(String exceptionDesc) {
		this.exceptionDesc = exceptionDesc;
	}

}
