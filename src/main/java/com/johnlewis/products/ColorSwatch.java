package com.johnlewis.products;

public class ColorSwatch {

    private String color;
    private String basicColor;
    private String skuId;

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setBasicColor(String basicColor) {
        this.basicColor = basicColor;
    }

    public String getBasicColor() {
        return basicColor;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getSkuId() {
        return skuId;
    }

    @Override
    public String toString() {
        return "ColorSwatch{" +
                "color='" + color + '\'' +
                ", basicColor='" + basicColor + '\'' +
                ", skuId='" + skuId + '\'' +
                '}';
    }
}
