package com.cryptocurrencies.jpa.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "cryptocurrencies")
public class Currency {

	@Id
	private String id;

	@Field("currency")
	private String currency;

	@Field("date")
	private String date;

	@Field("quotes")
	private List<String> quotes;

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

	public static final class CurrencyBuilder {
		private String id;
		private String currency;
		private String date;
		private List<String> quotes;

		private CurrencyBuilder() {
		}

		public static CurrencyBuilder anCurrency() { return  new CurrencyBuilder(); }

		public CurrencyBuilder withId(String id) {
			this.id = id;
			return this;
		}

		public CurrencyBuilder withCurrency(String currency) {
			this.currency = currency;
			return this;
		}

		public CurrencyBuilder withDate(String date) {
			this.date = date;
			return this;
		}

		public CurrencyBuilder withQuotes(List<String> quotes) {
			this.quotes = quotes;
			return this;
		}

		public Currency build() {
			Currency newCurrency = new Currency();
			newCurrency.setId(id);
			newCurrency.setCurrency(currency);
			newCurrency.setDate(date);
			newCurrency.setQuotes(quotes);
			return newCurrency;
		}
	}
}
