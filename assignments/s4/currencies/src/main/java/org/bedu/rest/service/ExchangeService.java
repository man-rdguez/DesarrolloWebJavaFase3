package org.bedu.rest.service;

import org.bedu.rest.exception.AmountIsNegativeException;
import org.bedu.rest.exception.CurrencyNotFoundException;
import org.bedu.rest.model.Exchange;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ExchangeService {

   private List<Exchange> exchanges;

   public ExchangeService() {
      exchanges = new ArrayList<>();

      exchanges.add( new Exchange( "MXN","USD", 0.057 ) );
      exchanges.add( new Exchange( "MXN","EUR", 0.053 ) );
      exchanges.add( new Exchange( "USD","MXN", 17.63 ) );
      exchanges.add( new Exchange( "USD","EUR", 0.93 ) );
      exchanges.add( new Exchange( "EUR","MXN", 18.91 ) );
      exchanges.add( new Exchange( "EUR","USD", 1.07 ) );
   }

   public Map<String,Double> getExchanges( String from ) {

      if ( exists( from ) == false ) {
         throw new CurrencyNotFoundException( from );
      }

      Map<String,Double> selExchanges = new HashMap<>();

      exchanges
         .stream()
         .filter( exchange -> exchange.getFrom().equals( from ) )
         .forEach( exchange -> selExchanges.put( exchange.getTo(), exchange.getRate() ) );

      return selExchanges;
   }

   public boolean exists(String from) {
      return exchanges
         .stream()
         .map( exc -> exc.getFrom() )
         .anyMatch( code -> code.equals(from) );
   }

   public Map<String, Double> getConversions( String from, double amount ) {

      if ( amount < 0 ) {
         throw new AmountIsNegativeException();
      }

      if ( exists( from ) == false ) {
         throw new CurrencyNotFoundException( from );
      }

      Map<String,Double> selExchanges = new HashMap<>();

      exchanges
         .stream()
         .filter( exchange -> exchange.getFrom().equals( from ) )
         .forEach( exchange -> selExchanges.put( exchange.getTo(), round(exchange.getRate() * amount ) ) );

      return selExchanges;
   }

   private double round( double number ) {

      BigDecimal bd = new BigDecimal(Double.toString(number));
      bd = bd.setScale(2, RoundingMode.HALF_UP);

      return bd.doubleValue();
   }

}
