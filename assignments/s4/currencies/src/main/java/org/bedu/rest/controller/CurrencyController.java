package org.bedu.rest.controller;

import org.bedu.rest.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import org.bedu.rest.service.CurrencyService;

@RestController
@RequestMapping("currencies")
@Validated
public class CurrencyController {

  private CurrencyService currency;
  private ExchangeService exchange;

  @Autowired
  public CurrencyController(CurrencyService currency, ExchangeService exchange ) {
    this.currency = currency;
    this.exchange = exchange;
  }

  // GET /currencies -> Get all currencies
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<String> getCurrencies() {
    return currency.getCurrencies();
  }

  @GetMapping("{code}")
  public Map<String,Double> getExchanges(@PathVariable("code") String code) {
    return exchange.getExchanges( code );
  }

  @GetMapping("{code}/exchanges/{amount}")
  public Map<String,Double> getConversions(
     @PathVariable("code") String code,
     @PathVariable("amount") double amount
     ) {
    return exchange.getConversions( code, amount );
  }

}
