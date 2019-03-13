package com.cryptocurrencies.service;

import com.cryptocurrencies.jpa.dao.CurrencyDAL;
import com.cryptocurrencies.jpa.entity.Currency;
import com.cryptocurrencies.model.CurrencyDTO;
import com.cryptocurrencies.model.MaxProfit;
import com.cryptocurrencies.model.Quotes;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CurrencyServiceImpl implements CurrencyService {

	private final CurrencyDAL currencyDAL;

	public CurrencyServiceImpl(CurrencyDAL currencyDAL) {
		this.currencyDAL = currencyDAL;
	}

	@Override
	public CurrencyDTO getCurrency(String currencyCode) throws Exception {
		Currency currency = currencyDAL.getCurrency(currencyCode);
		CurrencyDTO currencyDTO = CurrencyDTO.CurrencyDTOBuilder.anCurrencyDTO()
				.withId(currency.getId())
				.withCurrency(currency.getCurrency())
				.withDate(currency.getDate())
				.withQuotes(currency.getQuotes())
				.build();
		return currencyDTO;
	}

	@Override
	public List<CurrencyDTO> getAllCurrencies() throws Exception {
		List<Currency> listCurrencies = currencyDAL.getAllCurrencies();
		List<CurrencyDTO> currencies = listCurrencies.stream().map(CurrencyDTO::new).collect(Collectors.toList());

		return currencies;
	}

	@Override
	public Map<String, MaxProfit> getMaximumProfit() throws Exception {
		List<Currency> listCurrencies = currencyDAL.getAllCurrencies();

		Map<String, MaxProfit> maxProfitMap = new HashMap<>();

		listCurrencies.forEach((Currency currency) ->
			maxProfitMap.put(currency.getCurrency(), getMaxProfit(currency))
		);

		return maxProfitMap;
	}

	/**
	 * Compute the maximum profit for a given currency.
	 *
	 * @param currency
	 * @return MaxProfit object
	 */
	private MaxProfit getMaxProfit(Currency currency) {
		List<String> quotes = currency.getQuotes();

		List<String> quoteTimes = new ArrayList<>();
		List<BigDecimal> quotePrices = new ArrayList<>();

		quotes.forEach(item -> {
			Gson gson = new Gson();
			Quotes model = gson.fromJson(item, Quotes.class);
			quoteTimes.add(model.getTime());
			quotePrices.add(model.getPrice());

		});

		BigDecimal currentProfit;
		BigDecimal currentBuy = quotePrices.get(0);
		BigDecimal sell = quotePrices.get(1);
		BigDecimal profit = sell.subtract(currentBuy);

		String buyTime = quoteTimes.get(0);
		String sellTime = quoteTimes.get(1);

		for (int i = 1; i < quotePrices.size(); i++) {
			currentProfit = quotePrices.get(i).subtract(currentBuy);
			if (currentProfit.doubleValue() > profit.doubleValue()) {
				profit = currentProfit;
				sell = quotePrices.get(i);
				sellTime = quoteTimes.get(i);

				if (quotePrices.get(i).doubleValue() < currentBuy.doubleValue()) {
					currentBuy = quotePrices.get(i);
					buyTime = quoteTimes.get(i);
				}
			}
		}

		return MaxProfit.MaxProfitBuilder.anMaxProfit()
				.withBuyPrice(currentBuy)
				.withBuyTime(buyTime)
				.withSellPrice(sell)
				.withSellTime(sellTime)
				.withProfit(profit)
				.build();
	}

}
