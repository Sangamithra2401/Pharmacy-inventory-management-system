package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.examly.springapp.model.Category;
import com.examly.springapp.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
     @Autowired
     private CategoryService service;

     @PostMapping
     public ResponseEntity<Category> CreateCategory(@RequestBody(required = false) Category category){
         return new ResponseEntity<>(service.CreateCategory(category), HttpStatus.CREATED);
     }

     @GetMapping
     public ResponseEntity<List<Category>> GetAllCategories(){
      List<Category> list=service.GetAllCategories();
      return new ResponseEntity<>(list,HttpStatus.OK);
     }

     @PutMapping("/{id}")
     public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category category){
         return new ResponseEntity<>(service.updateCategory(id,category),HttpStatus.OK);
     }

     @DeleteMapping("/{id}")
     public ResponseEntity<Category> deleteCategory(@PathVariable Long id){
      service.deleteCategory(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }

     @GetMapping("/{id}")
     public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long id){
        Category category=service.GetCategoryById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
     }
     @GetMapping("/page/{pageNo}/{pageSize}")
     public Page<Category> sortPage(@PathVariable int pageNo,@PathVariable int pageSize)
     {
        return service.sortPage(pageNo,pageSize);
     }
}