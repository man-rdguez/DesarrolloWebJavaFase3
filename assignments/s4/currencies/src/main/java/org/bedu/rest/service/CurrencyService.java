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

  /*
  public boolean exists(String name) {
    return currency.containsKey(name.toLowerCase());
  }
  */

  public List<String> getCurrencies() {
    return currency.stream().map( curr -> curr.getCode() ).collect(Collectors.toList());
  }

  /*
  public Currency getOne(String name) {
    if (!exists(name)) {
      throw new ContactNotFoundException(name);
    }

    return currency.get(name.toLowerCase());
  }

  public Currency add(Currency currency) {
    if (exists(currency.getName())) {
      throw new ContactAlreadyExistsException();
    }

    currency.put(currency.getName().toLowerCase(), currency);
    return currency;
  }

  public void update(String name, UpdatedContact contact) {
    if (!exists(name)) {
      throw new ContactNotFoundException(name);
    }

    Currency current = currency.get(name);
    current.setNumber(contact.getNumber());
  }

  public void remove(String name) {
    if (!exists(name)) {
      throw new ContactNotFoundException(name);
    }

    currency.remove(name);
  }

  */
}
