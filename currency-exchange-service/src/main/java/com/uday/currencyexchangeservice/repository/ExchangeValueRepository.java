package com.uday.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uday.currencyexchangeservice.ExchangeValue;

@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue,Long> {
	ExchangeValue findByCurrencyFromAndCurrencyTo(String currencyFrom,String currencyTo);
}
