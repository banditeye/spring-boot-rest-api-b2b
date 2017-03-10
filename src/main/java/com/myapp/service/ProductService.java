/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.service;

import com.myapp.domain.Product;
import com.myapp.dto.PageParams;
import com.myapp.dto.ProductDTO;
import com.myapp.dto.ProductParams;
import com.myapp.service.exceptions.NotPermittedException;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 *
 * @author Kamil
 */
public interface ProductService {
        void delete(Long id) throws NotPermittedException;
        Page<ProductDTO> findAll(PageRequest pageable);
        List<Product> findByUser(Long userId, PageParams pageParams);
        List<ProductDTO> findMyProduct(PageParams pageParams);
        Product saveMyProduct(ProductParams params);
        Product updateMyProduct(Product product);
        
}
