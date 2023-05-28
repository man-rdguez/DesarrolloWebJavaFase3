package org.bedu.rest.model;

import org.bedu.rest.validation.PhoneNumber;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Currency {

  public Currency(String name, String code) {
    this.name = name;
    this.code = code;
  }

  @NotBlank
  private String name;
  @NotBlank
  @Size(min = 3, max = 3)
  private String code;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

}
