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

    public void setWas(BigDecimal was) {
        this.was = was;
    }

    public BigDecimal getWas() {
        return was;
    }

    public void setThen1(BigDecimal then1) {
        this.then1 = then1;
    }

    public BigDecimal getThen1() {
        return then1;
    }

    public void setThen2(BigDecimal then2) {
        this.then2 = then2;
    }

    public BigDecimal getThen2() {
        return then2;
    }

    //TODO: now price can be either format:
    //"now":"50.00"
    //"now":{"from":"55.00","to":"100.00"}
    //those with a price range are not discounted, so can ignore?

    public void setNow(Object nowPriceObject) {
        String nowPriceString = nowPriceObject.toString();
        try {
            Double.parseDouble(nowPriceString);
            now = new BigDecimal(nowPriceString);
        } catch (NumberFormatException e) {
            System.out.println("Unknown price format:" + nowPriceString);
        }
    }
    public BigDecimal getNow() {
        return now;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Price{" +
                "was=" + was +
                ", then1=" + then1 +
                ", then2=" + then2 +
                ", now=" + now +
                ", currency='" + currency + '\'' +
                '}';
    }
}
