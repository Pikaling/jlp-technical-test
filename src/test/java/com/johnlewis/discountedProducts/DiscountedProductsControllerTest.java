package com.johnlewis.discountedProducts;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiscountedProductsControllerTest {

    @Inject
    private DiscountedProductsController controller;

    @Test
    public void shouldGetDiscountedProducts() {
        controller.getProducts();
    }

}