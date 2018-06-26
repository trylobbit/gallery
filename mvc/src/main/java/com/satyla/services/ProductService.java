package com.satyla.services;

import com.satyla.model.Product;

import java.util.List;

public interface ProductService {

    void add(Product product);

    void updateProduct(long id, Product product);

    List<Product> getAllProducts(String currencyCode);

}
