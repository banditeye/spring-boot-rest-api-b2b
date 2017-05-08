/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.repository;

import com.myapp.domain.Category;
import com.myapp.domain.Subcategory;
import java.util.List;

/**
 *
 * @author Kamil
 */
public interface SubcategoryCustomRepository {
    List<Subcategory> getByIdCategory(Category category);
}
