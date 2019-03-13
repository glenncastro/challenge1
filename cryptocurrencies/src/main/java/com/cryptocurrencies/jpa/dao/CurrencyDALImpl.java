package com.cryptocurrencies.jpa.dao;

import com.cryptocurrencies.jpa.entity.Currency;
import com.cryptocurrencies.exception.ResourceNotFoundException;
import com.mongodb.MongoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CurrencyDALImpl implements CurrencyDAL {
	private static final Logger LOG = LoggerFactory.getLogger(CurrencyDALImpl.class);

	@Autowired
	private  CurrencyRepository currencyRepository;

	@Override
	public Currency getCurrency(String currencyCode) throws MongoException {
		LOG.debug("Get Currency " + currencyCode + " from DB start");

		Optional<Currency> currency;

		try {
			currency = currencyRepository.findByCurrency(currencyCode);

			if (!currency.isPresent()) {
				LOG.error("Currency " + currencyCode + " is not found in DB");
				throw new ResourceNotFoundException(currencyCode, " not found");
			}
		} catch (MongoException e) {
			LOG.error("Status : " + e.getClass() + ", due to" + e.getMessage());
			throw new MongoException("Exception while getting currency " + currencyCode + " in the DB", e.getCause());
		} catch (DataAccessException e) {
			LOG.error("Status : " + e.getClass() + ", due to" + e.getMessage());
			throw new MongoException("Exception  while getting currency " + currencyCode + " in the DB", e.getCause());
		}

		LOG.debug("Get Currency " + currencyCode + " from DB complete");


		return currency.get();
	}

	@Override
	public List<Currency> getAllCurrencies() throws MongoException {
		LOG.debug("Get All Currencies from DB start");

		List<Currency> currencies;

		try {
			currencies = currencyRepository.findAll();

			if (currencies.isEmpty()) {
				LOG.error("Currencies not found in DB");
				throw new ResourceNotFoundException("Currencies not found");
			}
		} catch (MongoException e) {
			LOG.error("Status : " + e.getClass() + ", due to" + e.getMessage());
			throw new MongoException("Exception while getting currencies in the DB", e.getCause());
		} catch (DataAccessException e) {
			LOG.error("Status : " + e.getClass() + ", due to" + e.getMessage());
			throw new MongoException("Exception  while getting currencies in the DB", e.getCause());
		}

		LOG.debug("Get All Currencies from DB complete");

		return currencies;

	}
}
