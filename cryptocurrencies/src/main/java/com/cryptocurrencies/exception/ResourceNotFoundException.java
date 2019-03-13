package com.cryptocurrencies.exception;

public class ResourceNotFoundException extends RuntimeException {

	private String resource;

	public ResourceNotFoundException(String resourceId, String message) {
		super(message);
		this.resource = resourceId;
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}

	public String getResource() {
		return resource;
	}
}
