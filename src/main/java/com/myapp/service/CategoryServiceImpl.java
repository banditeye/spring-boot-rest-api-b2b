/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.service;

import com.myapp.domain.Category;
import com.myapp.repository.CategoryRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kamil
 */
@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    
    
    
    @Override
    public List<Category> findAll() {
       return categoryRepository.findAll();
    }
    
    
}
