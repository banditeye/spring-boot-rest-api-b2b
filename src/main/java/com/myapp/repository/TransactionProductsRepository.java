/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.repository;

import com.myapp.domain.TransactionProducts;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Kamil
 */
public interface TransactionProductsRepository extends JpaRepository<TransactionProducts, Long> {
    
    
}
