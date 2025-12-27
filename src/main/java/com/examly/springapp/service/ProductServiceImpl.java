package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.exception.NoContentException;
import com.examly.springapp.exception.ResourceNotFoundException;
import com.examly.springapp.model.Product;
import com.examly.springapp.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo repo;

    @Override
    public Product addProduct(Product product) {
        return repo.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> prod= repo.findAll();
        if(prod.isEmpty()){
            throw new NoContentException("No Products Available");
        }
        return prod;
    }

    @Override
    public Product getProductById(Long id) {
        return repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Product is not found with respective id to update.."));
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existing = repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Product is not found with respective id to update.."));
        if (existing != null) {
            existing.setProductName(product.getProductName());
            existing.setDescription(product.getDescription());
            existing.setCategory(product.getCategory());
            return repo.save(existing);
        }
        return null;
    }


    @Override
    public List<Product> getProductByName(String name) {
        return repo.findByProductName(name);
    }

    @Override
    public List<Product> getProductsBycategoryName(String categoryName) {
        return repo.findByCategory_CategoryNameIgnoreCase(categoryName);
    }
    
}
