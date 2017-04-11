/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.service;

import com.myapp.domain.Category;
import java.util.List;

/**
 *
 * @author Kamil
 */
public interface CategoryService {
   
     List<Category> findAll();
    
}
