/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.controller;

import com.myapp.domain.Subcategory;
import com.myapp.service.ProductService;
import com.myapp.service.SubcategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Kamil
 */
@Controller
@RequestMapping("/api/subcategory")
public class SubcategoryController {

    private final SubcategoryService subcategoryService;

    @Autowired
    public SubcategoryController(SubcategoryService subcategoryService) {
        this.subcategoryService = subcategoryService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Subcategory> list() {
        return subcategoryService.findAll();

    }
    
     @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public @ResponseBody List<Subcategory> listByProduct(@PathVariable("id") Long id) {
        return subcategoryService.getByIdCategory(id);

    }
      
     @RequestMapping(value = "name/{name}", method = RequestMethod.GET)
    public @ResponseBody List<Subcategory> listByProductName(@PathVariable("name") String name) {
        return subcategoryService.getByCategoryName(name);

    }

}
