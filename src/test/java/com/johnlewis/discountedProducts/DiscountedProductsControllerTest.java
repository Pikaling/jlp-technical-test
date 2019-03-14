package com.johnlewis.discountedProducts;

import com.johnlewis.products.Product;
import com.johnlewis.products.ProductsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.json.Json;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class DiscountedProductsControllerTest {

    @Autowired
    private ProductsService mockProductsService;

    @Autowired
    private DiscountedProductsController controller;

    @Test
    public void shouldGetDiscountedProducts() {
        List<Product> testProducts = new ArrayList<>();
        ProductBuilder productBuilder = new ProductBuilder();
        testProducts.add(productBuilder.withNowPrice(Json.createObjectBuilder().add("from", "55.00").add("to", "100.00").build()).build());

        when(mockProductsService.getProducts()).thenReturn(testProducts);

        controller.getProducts();
    }

}