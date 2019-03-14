package com.johnlewis.discountedProducts;

import com.johnlewis.products.Product;
import com.johnlewis.products.ProductBuilder;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
@SpringBootTest
public class ProductMapperTest {

    @Autowired
    private ProductMapper mapper;

    @ClassRule
    public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();

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

    @Test
    @Parameters({"2.00, £2.00",
            "10.00, £10",
            "100.00, £100",
            "1.99, £1.99",
            "10.50, £10.50"})
    public void shouldConvertPriceNowToString(String nowPriceString, String formattedNowPriceString) {
        Product product = builder.withNowPrice(nowPriceString).build();

        DiscountedProduct discountedProduct = mapper.toDiscountedProduct(product);

        assertThat(discountedProduct.getNowPrice()).isEqualTo(formattedNowPriceString);
    }

}