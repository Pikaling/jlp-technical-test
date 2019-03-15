package com.johnlewis.discountedProducts;

import com.johnlewis.products.Price;
import com.johnlewis.products.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

@Component
class ProductMapper {

    public static final String DEFAULT_LABEL_TYPE = "ShowWasNow";

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

    private String currencySymbol;

    public DiscountedProduct toDiscountedProduct(Product product, String labelType) {
        currencySymbol = Currency.getInstance(product.getPrice().getCurrency()).getSymbol();
        labelType = labelType == null ? DEFAULT_LABEL_TYPE : labelType;
        DiscountedProduct discountedProduct = new DiscountedProduct();
        discountedProduct.setProductId(product.getProductId());
        discountedProduct.setTitle(product.getTitle());
        discountedProduct.setColorSwatches(mapColorSwatches(product.getColorSwatches()));
        discountedProduct.setNowPrice(generatePriceString(product.getPrice().getNow()));
        discountedProduct.setPriceLabel(generatePriceLabel(product.getPrice(), discountedProduct.getNowPrice(), labelType));
        return discountedProduct;
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

    private String generatePriceString(BigDecimal price) {
        String priceString = price.toString();
        if (price.compareTo(BigDecimal.TEN) >= 0) {
            priceString = removeDecimalsFromIntegerValue(price);
        }
        return currencySymbol + priceString;
    }

    private String generatePriceLabel(Price price, String nowPrice, String labelType) {
        String priceLabel = null;
        switch (labelType) {
            case "ShowWasNow":
                priceLabel = getShowWasNowLabel(price, nowPrice);
                break;
            case "ShowWasThenNow":
                BigDecimal thenPrice = price.getThen2() != null ? price.getThen2() : price.getThen1();
                if (thenPrice != null) {
                    priceLabel = getShowWasThenNowLabel(price, nowPrice, thenPrice);
                } else {
                    priceLabel = getShowWasNowLabel(price, nowPrice);
                }
                break;
            case "ShowPercDiscount":
                BigDecimal percentDiscount = getPercentDiscount(price);
                priceLabel = String.format("%s%% off - now %s", removeDecimalsFromIntegerValue(percentDiscount), nowPrice);
        }
        return priceLabel;
    }

    private String removeDecimalsFromIntegerValue(BigDecimal decimal) {
        String decimalString = decimal.toString();
        if (decimal.stripTrailingZeros().scale() <= 0) {
            decimalString = Integer.toString(decimal.intValue());
        }
        return decimalString;
    }

    private String getShowWasNowLabel(Price price, String nowPrice) {
        return String.format("Was %s, now %s", generatePriceString(price.getWas()), nowPrice);
    }

    private String getShowWasThenNowLabel(Price price, String nowPrice, BigDecimal thenPrice) {
        return String.format("Was %s, then %s, now %s", generatePriceString(price.getWas()), generatePriceString(thenPrice), nowPrice);
    }

    private BigDecimal getPercentDiscount(Price price) {
        return (price.getWas().subtract(price.getNow())).divide(price.getWas()).multiply(BigDecimal.valueOf(100));
    }

}
