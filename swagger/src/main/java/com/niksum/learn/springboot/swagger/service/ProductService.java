package com.niksum.learn.springboot.swagger.service;

import com.niksum.learn.springboot.swagger.domain.Product;

public interface ProductService {
    Iterable<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);
}