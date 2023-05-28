package org.bedu.rest.config;

import org.bedu.rest.exception.AmountIsNegativeException;
import org.bedu.rest.exception.CurrencyNotFoundException;
import org.bedu.rest.model.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(AmountIsNegativeException.class)
  public ResponseEntity<ErrorResponse> handleAmountIsNegative() {
    return ResponseEntity
       .status(HttpStatus.NOT_FOUND)
       .body(new ErrorResponse("Amount to convert can not be negative"));
  }

  @ExceptionHandler(CurrencyNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleCurrencyNotFound(CurrencyNotFoundException ex) {
    return ResponseEntity
       .status(HttpStatus.NOT_FOUND)
       .body(new ErrorResponse(ex.getCode() + " was not found in exchange"));
  }

}
