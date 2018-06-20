package com.example.dlocal.businessExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "The supplied Merchant isn't exist")
public class ModelNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String modelName;
	private String key;
	private Object value;

	public ModelNotFoundException(String modelName, String key, Object value) {
		super(String.format("%s with %s '%s' is not found", modelName, key,
				value));
		this.modelName = modelName;
		this.key = key;
		this.value = value;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

}
