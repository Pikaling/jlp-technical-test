package com.johnlewis.discountedProducts;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.WRAPPER_OBJECT;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@JsonTypeName("products")
@JsonTypeInfo(include=WRAPPER_OBJECT, use=NAME)
public class DiscountedProducts {

    private final List<DiscountedProduct> products;

    public DiscountedProducts(List<DiscountedProduct> products) {
        this.products = products;
    }

    public List<DiscountedProduct> getProducts() {
        return products;
    }

}
