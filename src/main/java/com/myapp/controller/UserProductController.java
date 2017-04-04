/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.controller;

import com.myapp.domain.Product;
import com.myapp.dto.PageParams;
import com.myapp.dto.ProductDTO;
import com.myapp.service.ProductService;
import java.util.List;
import java.util.stream.Collectors;
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
@RequestMapping("/api/users")
public class UserProductController {
    
    private final ProductService productService;

    public UserProductController(ProductService productService) {
        this.productService = productService;
    }
  /*
      @RequestMapping(method = RequestMethod.GET, path = "/{userId:\\d+}/products")
    public List<Product> list(@PathVariable("userId") Long userId, PageParams pageParams) {
        return productService.findByUser(userId, pageParams).stream().collect(Collectors.toList());
    }
  */ 
       @RequestMapping(method = RequestMethod.GET, path = "/{userId:\\d+}/products")
    public @ResponseBody List<Product> list(@PathVariable("userId") Long userId, PageParams pageParams) {
        return productService.findByUser(userId, pageParams).stream().collect(Collectors.toList());
    }
}
