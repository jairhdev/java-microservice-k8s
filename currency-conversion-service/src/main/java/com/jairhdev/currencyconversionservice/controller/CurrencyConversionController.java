package com.jairhdev.currencyconversionservice.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jairhdev.currencyconversionservice.model.entities.CurrencyConversion;

@RestController
public class CurrencyConversionController {

    private Logger logger = LoggerFactory.getLogger(CurrencyConversionController.class);

    @Autowired
    private CurrencyExchangeProxy proxy;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to,
	    @PathVariable BigDecimal quantity) {

	logger.info("calculateCurrencyConversion called with {} to {} with {}", from, to, quantity);

	CurrencyConversion currencyConversion = proxy.retrieveExchangeValue(from, to);

	return new CurrencyConversion(currencyConversion.getId(), from, to, quantity,
		currencyConversion.getConversionMultiple(),
		quantity.multiply(currencyConversion.getConversionMultiple()), currencyConversion.getEnvironment());
    }

}
