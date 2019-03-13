package com.johnlewis.products;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

@Service
public class ProductsService {

    private static final String URL = "https://jl-nonprod-syst.apigee.net/v1/categories/600001506/products?key=2ALHCAAs6ikGRBoy6eTHA58RaG097Fma";

    private RestTemplate template;

    public ProductsService(RestTemplateBuilder restTemplateBuilder) {
        template = restTemplateBuilder.build();
    }

    public List<Product> getProducts() {
        Products products = template.getForObject(URL, Products.class);
        return products.getProducts();

    }
}
