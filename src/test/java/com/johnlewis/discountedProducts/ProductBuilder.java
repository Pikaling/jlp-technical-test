package com.johnlewis.discountedProducts;

import com.johnlewis.products.Price;
import com.johnlewis.products.Product;
import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

public class ProductBuilder {

    private String productId;
    private String title;
    private Object now;
    private BigDecimal was;
    private String currency = "GBP";

    public ProductBuilder() {
    }

    public ProductBuilder withNowPrice(Object nowPrice) {
        this.now = nowPrice;
        return this;
    }

    public ProductBuilder withWasPrice(BigDecimal wasPrice) {
        this.was = wasPrice;
        return this;
    }


    public Product build() {
        Product product = new Product();

        Random random = new Random();

        productId = productId == null ? RandomStringUtils.randomNumeric(7) : productId;
        title = title == null ? RandomStringUtils.randomPrint(100) : title;
        now = now == null ? random.nextDouble() : now;

        Price price = new Price();
        price.setCurrency(currency);
        price.setNow(now);
        price.setWas(was);

        product.setProductId(productId);
        product.setTitle(title);
        product.setColorSwatches(new ArrayList<>());
        product.setPrice(price);

        return product;
    }



}
