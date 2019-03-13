package com.johnlewis.discountedProducts;

import com.johnlewis.products.Product;
import com.johnlewis.products.ProductsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class DiscountedProductsController {

    @Inject
    private ProductsService productsService;

    @RequestMapping(value="/products", method=GET)
    public void getProducts() {
        List<Product> products = productsService.getProducts();
        List<Product> discountedProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice().getWas() != null ) {
                discountedProducts.add(product);
            }
        }
        System.out.println("Total products: " + products.size() + ", Discounted products: " + discountedProducts.size());
    }
}
