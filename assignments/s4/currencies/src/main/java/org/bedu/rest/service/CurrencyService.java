package org.bedu.rest.service;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.bedu.rest.model.Currency;

@Service
public class CurrencyService {

  private List<Currency> currency;

  public CurrencyService() {
    currency = new ArrayList<>();

    currency.add( new Currency( "Mexican Peso","MXN") );
    currency.add( new Currency( "American Dollar", "USD") );
    currency.add( new Currency( "Euro","EUR") );
  }

  public List<String> getCurrencies() {
    return currency.stream().map( curr -> curr.getCode() ).collect(Collectors.toList());
  }

}
