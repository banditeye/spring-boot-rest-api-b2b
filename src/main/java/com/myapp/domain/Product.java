/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Kamil
 */
@Entity
@Table(name = "product")
@NoArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;


    @NotNull
    private double price;

    @NotNull
    private String description;

    @NotNull
    private int pieces;
    
      @NotNull
    private int barcode;
        
    @NotNull
    private int sold;
    
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Subcategory subcategory;
    
    
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<Transaction> transactional;
    
   @PrePersist
    protected void onCreate() {
        sold=0;
    }

    public Product(String name, double price, String description, int pieces, int barcode) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.pieces = pieces;
        this.barcode = barcode;
    }

    public Product(String name, double price, String description, int pieces, int barcode, Subcategory subcategory) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.pieces = pieces;
        this.barcode = barcode;
        this.subcategory = subcategory;
    }

  @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<Basket> basket;
    

}
