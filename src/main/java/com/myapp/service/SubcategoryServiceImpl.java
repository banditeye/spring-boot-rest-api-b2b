/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.service;

import com.myapp.domain.Category;
import com.myapp.domain.Subcategory;
import com.myapp.repository.CategoryRepository;
import com.myapp.repository.SubcategoryCustomRepository;
import com.myapp.repository.SubcategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kamil
 */
@Service
public class SubcategoryServiceImpl implements SubcategoryService {
    private final SubcategoryRepository subcategoryRepository;
    private final SubcategoryCustomRepository subcategoryCustomRepository;
    private final CategoryRepository categoryRepository;
    
    @Autowired
    public SubcategoryServiceImpl(SubcategoryRepository subcategoryRepository, SubcategoryCustomRepository subcategoryCustomRepository, CategoryRepository categoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
        this.subcategoryCustomRepository = subcategoryCustomRepository;
        this.categoryRepository = categoryRepository;
    }

   

    @Override
    public List<Subcategory> findAll() {
        return subcategoryRepository.findAll();
    }

    @Override
    public List<Subcategory> getByIdCategory(Long id) {
        Category category=categoryRepository.findOne(id);
        return subcategoryCustomRepository.getByIdCategory(category);
    }

    @Override
    public List<Subcategory> getByCategoryName(String name) {
        Category category=categoryRepository.findByName(name);
        return subcategoryCustomRepository.getByIdCategory(category);
    }
    
    
}
