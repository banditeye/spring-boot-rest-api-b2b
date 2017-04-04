/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.repository;

import com.myapp.domain.Product;
import com.myapp.domain.Subcategory;
import com.myapp.domain.User;
import com.myapp.dto.PageParams;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Kamil
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
   @Query("select u from Product u where u.user = ?1")
    List<Product> findByUser(User user);
    @Query("select u from Product u where u.subcategory = ?1")
    List<Product> findBySubcategory(Subcategory subcategory, PageParams pageParams);
    Optional<Product> findById(Long id);
}
