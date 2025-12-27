package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.examly.springapp.exception.NoContentException;
import com.examly.springapp.exception.ResourceNotFoundException;
import com.examly.springapp.model.Category;
import com.examly.springapp.repository.CategoryRepo;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo repo;
    public Category CreateCategory(Category category){
        return repo.save(category);
    }

    public List<Category> GetAllCategories(){
        List<Category> cate=repo.findAll();
        if(cate.isEmpty()){
            throw new NoContentException("No Category Available");
        }
        return cate;
    }

    public Category GetCategoryById(Long id){
        return repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Category is not found with respective id to update.."));
    }

    public Category updateCategory(int id, Category category){
        Category existing = repo.findById((long)id).orElseThrow(()->new ResourceNotFoundException("Category is not found with respective id to update.."));
        if (existing != null) {
            existing.setCategoryName(category.getCategoryName());
            return repo.save(existing);
        }
        return null;
    }
    
    public void deleteCategory(Long id){
         repo.deleteById(id);
    }
    public Page<Category> sortPage(int pageNo,int pageSize)
    {
        Pageable pageable=PageRequest.of(pageNo,pageSize);
        return repo.findAll(pageable);
    }
}