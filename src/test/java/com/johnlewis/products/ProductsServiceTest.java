package com.johnlewis.products;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductsServiceTest {

    @Autowired
    private ProductsService productsService;

    @Test
    public void shouldGetProducts() {
        List<Product> products = productsService.getProducts();
        assertThat(products).isNotNull();

    }
}