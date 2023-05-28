package org.bedu.rest.exception;

public class CurrencyNotFoundException extends RuntimeException {

   private String code;

   public CurrencyNotFoundException(String code) {
      this.code = code;
   }

   public String getCode() {
      return code;
   }

   public void setCode(String code) {
      this.code = code;
   }

}
