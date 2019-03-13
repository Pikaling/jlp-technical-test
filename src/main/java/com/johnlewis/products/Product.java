package com.johnlewis.products;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
    private String productId;
    private String title;
    private List<ColorSwatch> colorSwatches;
    private Price price;

    public String getProductId() {
        return productId;
    }

    public String getTitle() {
        return title;
    }

    public List<ColorSwatch> getColorSwatches() {
        return colorSwatches;
    }

    public Price getPrice() {
        return price;
    }
}
