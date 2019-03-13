package com.johnlewis.products;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductsServiceTest {

    @Inject
    private ProductsService productsService;

    @Test
    public void shouldGetProducts() {
        List<Product> products = productsService.getProducts();
        assertThat(products).isNotNull();

    }
}