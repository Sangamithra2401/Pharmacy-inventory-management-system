package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.Product;

public interface ProductService {
    Product addProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product updateProduct(Long id, Product product);
    List<Product> getProductByName(String name);
    List<Product> getProductsBycategoryName(String categoryName);
}