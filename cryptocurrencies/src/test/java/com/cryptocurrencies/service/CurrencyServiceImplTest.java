package com.cryptocurrencies.service;

import com.cryptocurrencies.jpa.dao.CurrencyDAL;
import com.cryptocurrencies.jpa.dao.CurrencyRepository;
import com.cryptocurrencies.jpa.entity.Currency;
import com.cryptocurrencies.model.CurrencyDTO;
import com.cryptocurrencies.model.MaxProfit;
import com.google.gson.JsonObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("local")
public class CurrencyServiceImplTest {

	private CurrencyService currencyService;
	private CurrencyDAL currencyDAL;
	private CurrencyRepository currencyRepository;

	@Before
	public void setUp() throws Exception {
		currencyDAL = mock(CurrencyDAL.class);
		currencyRepository = mock(CurrencyRepository.class);

		currencyService = new CurrencyServiceImpl(currencyDAL);
	}

	@Test
	public void getAllCurrencies() throws Exception {
		List<String> quotes = populateBtcQuotes();

		Currency currency = Currency.CurrencyBuilder.anCurrency()
				.withId("1")
				.withCurrency("BTC")
				.withDate("20190101")
				.withQuotes(quotes)
				.build();
		List<Currency> listOfCurrencies = new ArrayList<>();
		listOfCurrencies.add(currency);

		when(currencyDAL.getAllCurrencies()).thenReturn(listOfCurrencies);

		List<CurrencyDTO> list = currencyService.getAllCurrencies();

		assertNotNull(list);
	}

	@Test
	public void getMaxProfit_btc() throws Exception {
		List<String> quotes = populateBtcQuotes();

		Currency currency = Currency.CurrencyBuilder.anCurrency()
				.withId("1")
				.withCurrency("BTC")
				.withDate("20190101")
				.withQuotes(quotes)
				.build();

		List<Currency> listOfCurrencies = new ArrayList<>();
		listOfCurrencies.add(currency);

		when(currencyDAL.getAllCurrencies()).thenReturn(listOfCurrencies);

		Map<String, MaxProfit> mapProfit = currencyService.getMaximumProfit();

		MaxProfit maxProfit = mapProfit.get("BTC");

		assertEquals(new BigDecimal("2.03"), maxProfit.getProfit());
	}

	private List<String> populateBtcQuotes() {
		List<String> quotes = new ArrayList<>();
		JsonObject btc = new JsonObject();
		btc.addProperty("time", "0915");
		btc.addProperty("price", 34.98);
		quotes.add(btc.toString());

		btc = new JsonObject();
		btc.addProperty("time", "1045");
		btc.addProperty("price", 36.13);
		quotes.add(btc.toString());

		btc = new JsonObject();
		btc.addProperty("time", "1230");
		btc.addProperty("price", 37.01);
		quotes.add(btc.toString());

		btc = new JsonObject();
		btc.addProperty("time", "1400");
		btc.addProperty("price", 35.98);
		quotes.add(btc.toString());

		btc = new JsonObject();
		btc.addProperty("time", "1530");
		btc.addProperty("price", 33.56);
		quotes.add(btc.toString());

		return quotes;
	}
}
