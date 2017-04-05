/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.controller;

import com.myapp.domain.Product;
import com.myapp.dto.PageParams;
import com.myapp.dto.ProductDTO;
import com.myapp.dto.ProductParams;
import com.myapp.service.ProductService;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Kamil
 */
@RestController
@RequestMapping("/api/product")
public class ProductController {

    private static final Integer DEFAULT_PAGE_SIZE = 5;

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<Product> list(@RequestParam(value = "page", required = false) @Nullable Integer page,
            @RequestParam(value = "size", required = false) @Nullable Integer size) {
        final PageRequest pageable = new PageRequest(
                Optional.ofNullable(page).orElse(1) - 1,
                Optional.ofNullable(size).orElse(DEFAULT_PAGE_SIZE));
        return productService.findAll(pageable);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Product create(@RequestBody ProductParams productParams) {
        return productService.saveMyProduct(productParams);
    }

    @RequestMapping(value = "{categoryId}", method = RequestMethod.GET)
    public List<Product> list(@PathVariable("categoryId") Long categoryId, PageParams pageParams) {
        return productService.findBySubcategory(categoryId, pageParams);

    }

}
