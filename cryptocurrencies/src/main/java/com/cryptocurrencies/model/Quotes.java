package com.cryptocurrencies.model;

import java.math.BigDecimal;

public class Quotes {

	private String time;
	private BigDecimal price;

	public Quotes(String time, BigDecimal price) {
		this.time = time;
		this.price = price;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getTime() {
		return time;
	}
}
