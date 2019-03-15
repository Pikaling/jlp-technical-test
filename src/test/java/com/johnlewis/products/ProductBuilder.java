package com.johnlewis.products;

import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductBuilder {

    public static final String DEFAULT_CURRENCY = "GBP";
    private String productId;
    private String title;
    private List<ColorSwatch> colorSwatches = new ArrayList<>();
    private String currency = DEFAULT_CURRENCY;
    private Price price = new Price();

    public ProductBuilder() {
    }

    public ProductBuilder withColorSwatch(String basicColor) {
        ColorSwatch colorSwatch = new ColorSwatch();
        colorSwatch.setColor(RandomStringUtils.randomAlphabetic(8));
        colorSwatch.setBasicColor(basicColor);
        colorSwatch.setSkuId(RandomStringUtils.randomNumeric(9));
        this.colorSwatches.add(colorSwatch);
        return this;
    }

    public ProductBuilder withNowPrice(String priceString) {
        price.setNow(priceString);
        return this;
    }

    public ProductBuilder withWasPrice(double wasPrice) {
        price.setWas(new BigDecimal(wasPrice));
        return this;
    }

    public ProductBuilder withPrice(Price price) {
        this.price = price;
        return this;
    }

    public Product build() {
        Random random = new Random();

        productId = productId == null ? RandomStringUtils.randomNumeric(7) : productId;
        title = title == null ? RandomStringUtils.randomPrint(100) : title;
        price.setCurrency(currency);

        if (price.getNow() == null) {
            price.setNow(RandomStringUtils.randomNumeric(2));
        }

        Product product = new Product();
        product.setProductId(productId);
        product.setTitle(title);
        product.setColorSwatches(colorSwatches);
        product.setPrice(price);

        this.clean();

        return product;
    }

    private void clean() {
        this.productId = null;
        this.title = null;
        this.currency = DEFAULT_CURRENCY;
        this.colorSwatches = new ArrayList<>();
        this.price = new Price();
    }
}
