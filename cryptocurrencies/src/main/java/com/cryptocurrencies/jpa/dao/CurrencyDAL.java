package com.cryptocurrencies.jpa.dao;

import com.cryptocurrencies.jpa.entity.Currency;
import com.mongodb.MongoException;

import java.util.List;

public interface CurrencyDAL {

	Currency getCurrency(String currencyCode) throws MongoException;
	List<Currency> getAllCurrencies() throws MongoException;
}
