package com.cryptocurrencies.rest;

import com.cryptocurrencies.model.CurrencyDTO;
import com.cryptocurrencies.model.MaxProfit;
import com.cryptocurrencies.service.CurrencyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@ResponseBody
public class CurrencyController {
	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	private CurrencyService currencyService;

	@PostConstruct
	private void _init() {
		LOG.debug("-----Booting up CURRENCY REST controller!!!!!!");
	}

	/**
	 * Rest controller for getting a currency data
	 * @param currencyCode
	 * @return the currency object
	 * @throws Exception
	 */
	@GetMapping(value = "/currencies/{currencyCode}",
		produces = "application/json")
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<CurrencyDTO> getCurrency(@PathVariable String currencyCode) throws Exception {
		LOG.debug("Getting currency in Controller");
		CurrencyDTO currency = currencyService.getCurrency(currencyCode.toUpperCase());

		return new ResponseEntity<>(currency, HttpStatus.OK);
	}

	@GetMapping(value = "/currencies",
		produces = "application/json")
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<List<CurrencyDTO>> getAllCurrencies() throws Exception {
		LOG.debug("Getting all Currencies in Controller");
		List<CurrencyDTO> currencies = currencyService.getAllCurrencies();

		return new ResponseEntity<>(currencies, HttpStatus.OK);
	}

	@GetMapping(value = "/currencies/profits",
			produces = "application/json")
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<List<Map>> getMaximumProfit() throws Exception {
		Map<String, MaxProfit> maxProfitMap = currencyService.getMaximumProfit();
		List l = new ArrayList();
		l.add(maxProfitMap);
		return new ResponseEntity<>(l, HttpStatus.OK);
	}


}
