package com.johnlewis.discountedProducts;

import com.johnlewis.products.Price;

import java.math.BigDecimal;

public enum PriceLabelTestData {

    DEFAULT("10.00", "9.00", null, "8.00", null, "Was £10, now £8.00"),
    SHOW_WAS_NOW("20.00", "15.00", null, "10.00", "ShowWasNow", "Was £20, now £10"),
    SHOW_WAS_THEN1_NOW("18.00", "12.00", null, "6.00", "ShowWasThenNow", "Was £18, then £12, now £6.00"),
    SHOW_WAS_THEN1_THEN2_NOW("50.00", "39.99", "29.99", "19.99", "ShowWasThenNow", "Was £50, then £29.99, now £19.99"),
    SHOW_WAS_NOW_NO_THEN("40.00", null, null, "20.00", "ShowWasThenNow", "Was £40, now £20"),
    SHOW_PERC_DISCOUNT("50.00", null, null, "30.00", "ShowPercDiscount", "40% off - now £30");

    private final Price price;
    private final String labelType;
    private final String expectedResult;

    PriceLabelTestData(String was, String then1, String then2, String now, String labelType, String expectedResult) {
        this.price = new Price();
        if (was != null) {
            price.setWas(new BigDecimal(was));
        }
        if (then1 != null) {
            price.setThen1(new BigDecimal(then1));
        }
        if (then2 != null) {
            price.setThen2(new BigDecimal(then2));
        }
        price.setNow(now);
        this.labelType = labelType;
        this.expectedResult = expectedResult;
    }

    public Price getPrice() {
        return price;
    }

    public String getLabelType() {
        return labelType;
    }

    public String getExpectedResult() {
        return expectedResult;
    }
}
