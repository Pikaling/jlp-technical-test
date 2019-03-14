package com.johnlewis.discountedProducts;

import com.johnlewis.products.Product;
import com.johnlewis.products.ProductBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductMapperTest {

    @Autowired
    private ProductMapper mapper;

    private ProductBuilder builder = new ProductBuilder();

    @Test
    public void shouldMapProductId() {
        Product product = builder.build();
        String expectedProductId = product.getProductId();
        DiscountedProduct discountedProduct = mapper.toDiscountedProduct(product);
        assertThat(discountedProduct.getProductId()).isEqualTo(expectedProductId);
    }

    @Test
    public void shouldMapTitle() {
        Product product = builder.build();
        String expectedTitle = product.getTitle();
        DiscountedProduct discountedProduct = mapper.toDiscountedProduct(product);
        assertThat(discountedProduct.getTitle()).isEqualTo(expectedTitle);
    }

    @Test
    public void shouldMapColorSwatch() {
        Product product = builder.withColorSwatch("Red").build();
        com.johnlewis.products.ColorSwatch inputColorSwatch = product.getColorSwatches().get(0);
        String expectedColor = inputColorSwatch.getColor();
        String expectedSkuId = inputColorSwatch.getSkuId();

        DiscountedProduct discountedProduct = mapper.toDiscountedProduct(product);
        ColorSwatch outputColorSwatch = discountedProduct.getColorSwatches().get(0);

        assertThat(outputColorSwatch.getColor()).isEqualTo(expectedColor);
        assertThat(outputColorSwatch.getSkuId()).isEqualTo(expectedSkuId);
        assertThat(outputColorSwatch.getRgbColor()).isEqualTo("FF0000");
    }

}