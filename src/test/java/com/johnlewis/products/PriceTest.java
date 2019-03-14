package com.johnlewis.products;

import org.junit.Test;

import javax.json.Json;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class PriceTest {

    @Test
    public void shouldSetNowPriceIfSingleValueProvided() {
        Price price = new Price();
        price.setNow("33.00");

        assertThat(price.getNow()).isNotNull();
        assertThat(price.getNow()).isEqualTo(new BigDecimal("33.00"));
    }

    @Test
    public void shouldNotSetNowPriceIfValueRangeProvided() {
        Price price = new Price();
        Object now = Json.createObjectBuilder().add("from", "55.00").add("to", "100.00").build();
        price.setNow(now);

        assertThat(price.getNow()).isNull();

    }

}