package com.johnlewis.products;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
    private String productId;
    private String title;
    private List<ColorSwatch> colorSwatches;
    private Price price;

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setColorSwatches(List<ColorSwatch> colorSwatches) {
        this.colorSwatches = colorSwatches;
    }

    public List<ColorSwatch> getColorSwatches() {
        return colorSwatches;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Price getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", title='" + title + '\'' +
                ", colorSwatches=" + colorSwatches +
                ", price=" + price +
                '}';
    }
}
