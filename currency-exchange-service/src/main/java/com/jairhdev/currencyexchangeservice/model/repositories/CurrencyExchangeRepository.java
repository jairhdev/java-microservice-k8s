package com.jairhdev.currencyexchangeservice.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jairhdev.currencyexchangeservice.model.entities.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
    CurrencyExchange findByFromAndTo(String from, String to);
}
