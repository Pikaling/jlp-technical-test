package com.johnlewis.discountedProducts;

import com.johnlewis.products.Product;
import com.johnlewis.products.ProductBuilder;
import com.johnlewis.products.ProductsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class DiscountedProductsControllerTest {

    @Autowired
    private ProductsService mockProductsService;

    @Autowired
    private DiscountedProductsController controller;
    private List<Product> testProducts;
    private ProductBuilder builder = new ProductBuilder();

    @Before
    public void setUp() {
        testProducts = new ArrayList<>();
    }

    @Test
    public void shouldGetDiscountedProducts() {
        testProducts.add(builder.build());
        testProducts.add(builder.withWasPrice(20.00).build());

        when(mockProductsService.getProducts()).thenReturn(testProducts);

        DiscountedProducts discountedProducts = controller.getProducts(null);
        assertThat(discountedProducts).isNotNull();

        List<DiscountedProduct> products = discountedProducts.getProducts();
        assertThat(products).isNotNull();
        assertThat(products.size()).isEqualTo(1);
    }

}