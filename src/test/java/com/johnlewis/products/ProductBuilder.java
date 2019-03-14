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
    private Object now;
    private BigDecimal was;
    private List<ColorSwatch> colorSwatches = new ArrayList<>();
    private String currency = DEFAULT_CURRENCY;

    public ProductBuilder() {
    }

    public ProductBuilder withWasPrice(double price) {
        this.was = new BigDecimal(price);
        return this;
    }

    public ProductBuilder withColorSwatch(String basicColor) {
        ColorSwatch colorSwatch = new ColorSwatch();
        colorSwatch.setColor(RandomStringUtils.randomAlphabetic(8));
        colorSwatch.setBasicColor(basicColor);
        colorSwatch.setSkuId(RandomStringUtils.randomNumeric(9));
        this.colorSwatches.add(colorSwatch);
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
        product.setColorSwatches(colorSwatches);
        product.setPrice(price);

        this.clean();

        return product;
    }

    private void clean() {
        this.productId = null;
        this.title = null;
        this.currency = DEFAULT_CURRENCY;
        this.was = null;
        this.now = null;
        this.colorSwatches = new ArrayList<>();
    }
}
