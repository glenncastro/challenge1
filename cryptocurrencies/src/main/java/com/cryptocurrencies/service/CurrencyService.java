package com.cryptocurrencies.service;

import com.cryptocurrencies.model.CurrencyDTO;
import com.cryptocurrencies.model.MaxProfit;

import java.util.List;
import java.util.Map;

public interface CurrencyService {

	CurrencyDTO getCurrency(String currencyCode) throws Exception;

	List<CurrencyDTO> getAllCurrencies() throws Exception;

	Map<String, MaxProfit> getMaximumProfit() throws Exception;
}
