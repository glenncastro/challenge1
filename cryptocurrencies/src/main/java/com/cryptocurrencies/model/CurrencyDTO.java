package com.cryptocurrencies.model;

import com.cryptocurrencies.jpa.entity.Currency;

import java.util.List;

public class CurrencyDTO {

	private String id;
	private String currency;
	private String date;
	private List<String> quotes;

	public CurrencyDTO() { }

	public CurrencyDTO(String id, String currency, String date, List<String> quotes) {
		this.id = id;
		this.currency = currency;
		this.date = date;
		this.quotes = quotes;
	}

	public CurrencyDTO(Currency currency) {
		this(currency.getId(), currency.getCurrency(), currency.getDate(), currency.getQuotes());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<String> getQuotes() {
		return quotes;
	}

	public void setQuotes(List<String> quotes) {
		this.quotes = quotes;
	}

	public static final class CurrencyDTOBuilder {
		private String id;
		private String currency;
		private String date;
		private List<String> quotes;

		private CurrencyDTOBuilder() {
		}

		public static CurrencyDTOBuilder anCurrencyDTO() {
			return new CurrencyDTOBuilder();
		}

		public CurrencyDTOBuilder withId(String id) {
			this.id = id;
			return this;
		}

		public CurrencyDTOBuilder withCurrency(String currency) {
			this.currency = currency;
			return this;
		}

		public CurrencyDTOBuilder withDate(String date) {
			this.date = date;
			return this;
		}

		public CurrencyDTOBuilder withQuotes(List<String> quotes) {
			this.quotes = quotes;
			return this;
		}

		public CurrencyDTO build() {
			CurrencyDTO currencyDTO = new CurrencyDTO();
			currencyDTO.setId(id);
			currencyDTO.setCurrency(currency);
			currencyDTO.setDate(date);
			currencyDTO.setQuotes(quotes);
			return currencyDTO;
		}
	}
}
