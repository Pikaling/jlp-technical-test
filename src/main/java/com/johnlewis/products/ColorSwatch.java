package com.johnlewis.products;

public class ColorSwatch {

    private String color;
    private String basicColor;
    private String skuId;

    public String getColor() {
        return color;
    }

    public String getBasicColor() {
        return basicColor;
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
