/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Kamil
 */
@Entity
@Table(name = "transaction_products")
@NoArgsConstructor
@Data
public class TransactionProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     
     @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Transaction transaction;
    
     @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;
     
      @NotNull
    private long pieces;

    public TransactionProducts(Transaction transaction, Product product, long pieces) {
        this.transaction = transaction;
        this.product = product;
        this.pieces = pieces;
    }

 

   
      
      
    
}
