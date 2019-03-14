package com.johnlewis.discountedProducts;

import com.johnlewis.products.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

@Component
class ProductMapper {

    private static final Map<String, String> basicToRgb = new HashMap<>();

    static {
        basicToRgb.put("Red", "FF0000");
        basicToRgb.put("Blue", "0000FF");
        basicToRgb.put("Pink", "FFC0CB");
        basicToRgb.put("Black", "000000");
        basicToRgb.put("Green", "008000");
        basicToRgb.put("Grey", "808080");
        basicToRgb.put("Orange", "FFA500");
        basicToRgb.put("Purple", "800080");
        basicToRgb.put("White", "FFFFFF");
        basicToRgb.put("Yellow", "FFFF00");
    }

    public DiscountedProduct toDiscountedProduct(Product product) {
        DiscountedProduct discountedProduct = new DiscountedProduct();
        discountedProduct.setProductId(product.getProductId());
        discountedProduct.setTitle(product.getTitle());
        discountedProduct.setColorSwatches(mapColorSwatches(product.getColorSwatches()));
        discountedProduct.setNowPrice(generatePriceString(product.getPrice().getNow(), product.getPrice().getCurrency()));

        return discountedProduct;
    }

    private String generatePriceString(BigDecimal price, String currencyString) {
        String priceString = price.toString();
        if (price.compareTo(BigDecimal.TEN) >= 0 && price.stripTrailingZeros().scale() <=0) {
            priceString = Integer.toString(price.intValue());
        }
        Currency currency = Currency.getInstance(currencyString);
        return currency.getSymbol() + priceString;
    }

    private List<ColorSwatch> mapColorSwatches(List<com.johnlewis.products.ColorSwatch> inputColorSwatches) {
        List<ColorSwatch> outputColorSwatches = new ArrayList<>();
        for (com.johnlewis.products.ColorSwatch inputColorSwatch : inputColorSwatches) {
            ColorSwatch outputColorSwatch = new ColorSwatch();
            outputColorSwatch.setColor(inputColorSwatch.getColor());
            outputColorSwatch.setSkuId(inputColorSwatch.getSkuId());
            outputColorSwatch.setRgbColor(basicToRgb.getOrDefault(inputColorSwatch.getBasicColor(), null));
            outputColorSwatches.add(outputColorSwatch);
        }
        return outputColorSwatches;
    }

}
