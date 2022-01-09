package com.jairhdev.currencyconversionservice.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jairhdev.currencyconversionservice.model.entities.CurrencyConversion;

@FeignClient(name = "currency-exchange", url = "${CURRENCY_EXCHANGE_SERVICE_URI:http://localhost}:8000") // personalizada
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retrieveExchangeValue(@PathVariable String from, @PathVariable String to);

}
