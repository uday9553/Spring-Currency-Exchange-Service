package com.uday.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.uday.currencyexchangeservice.repository.ExchangeValueRepository;

@RestController
public class CurrencyExchangeController {
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Environment environment;
	@Autowired
	private ExchangeValueRepository exchangeValueRepository;
	@GetMapping("/currency-exchange/from/{currencyFrom}/to/{currencyTo}")
	public ExchangeValue retrieveExchangeValue(@PathVariable  String currencyFrom,
			@PathVariable String currencyTo) {
		ExchangeValue exchangeValue= exchangeValueRepository.findByCurrencyFromAndCurrencyTo(currencyFrom, currencyTo);
		
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		logger.info("{}",exchangeValue);
		return exchangeValue;
	}
}
