package com.johnlewis.discountedProducts;

import com.johnlewis.products.Product;
import com.johnlewis.products.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static com.johnlewis.discountedProducts.ProductMapper.DEFAULT_LABEL_TYPE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class DiscountedProductsController {

    @Autowired
    private ProductsService productsService;

    @Autowired
    private ProductMapper productMapper;

    @RequestMapping(value="/products", method=GET, produces = "applcation/json")
    public DiscountedProducts getProducts(@RequestParam(value="labelType", defaultValue = DEFAULT_LABEL_TYPE) String labelType) {
        List<Product> products = productsService.getProducts();
        List<DiscountedProduct> discountedProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice().getWas() != null ) {
                discountedProducts.add(productMapper.toDiscountedProduct(product, labelType));
            }
        }
        return new DiscountedProducts(discountedProducts);
    }
}
