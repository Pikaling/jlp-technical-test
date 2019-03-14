package com.johnlewis.discountedProducts;

import com.johnlewis.products.ProductsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import static org.mockito.Mockito.mock;

@Profile("test")
@Configuration
public class TestConfiguration {

    @Bean
    @Primary
    public ProductsService productsService() {
        return mock(ProductsService.class);
    }

}
