package com.jairhdev.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jairhdev.currencyexchangeservice.model.entities.CurrencyExchange;
import com.jairhdev.currencyexchangeservice.model.repositories.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {

    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @Autowired
    private CurrencyExchangeRepository repository;

    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {

	logger.info("retrieveExchangeValue called with {} to {}", from, to);

	CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
	if (currencyExchange == null) {
	    throw new RuntimeException("Not found. From: " + from + ". To: " + to);
	}

	currencyExchange.setEnvironment(MountEnvironmentString());
	return currencyExchange;
    }

    private String MountEnvironmentString() {
	String port = environment.getProperty("local.server.port");
	String host = environment.getProperty("HOSTNAME");
	return port + " " + host;
    }

}
