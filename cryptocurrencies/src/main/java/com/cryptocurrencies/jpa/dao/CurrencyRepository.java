package com.cryptocurrencies.jpa.dao;

import com.cryptocurrencies.jpa.entity.Currency;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyRepository extends MongoRepository<Currency, String> {

	Optional<Currency> findByCurrency(String currencyCode);
}
