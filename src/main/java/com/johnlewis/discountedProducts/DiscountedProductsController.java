package com.johnlewis.discountedProducts;

import com.johnlewis.products.Product;
import com.johnlewis.products.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class DiscountedProductsController {

    @Autowired
    private ProductsService productsService;

    @Autowired
    private ProductMapper productMapper;

    @RequestMapping(value="/products", method=GET)
    public List<DiscountedProduct> getProducts() {
        List<Product> products = productsService.getProducts();
        List<DiscountedProduct> discountedProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice().getWas() != null ) {
                discountedProducts.add(productMapper.toDiscountedProduct(product));
            }
        }
        return discountedProducts;
    }
}
