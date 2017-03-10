/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.repository;

import com.myapp.domain.Product;
import com.myapp.domain.User;
import com.myapp.dto.PageParams;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Kamil
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByUser(Long id, PageParams pageParams);
    Optional<Product> findById(Long id);
}
