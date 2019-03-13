package com.johnlewis.products;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Price {

    private BigDecimal was;
    private BigDecimal then1;
    private BigDecimal then2;
    private BigDecimal now;
    private String currency;

    public BigDecimal getWas() {
        return was;
    }

    public BigDecimal getThen1() {
        return then1;
    }

    public BigDecimal getThen2() {
        return then2;
    }

    public BigDecimal getNow() {
        return now;
    }

    public String getCurrency() {
        return currency;
    }
}
