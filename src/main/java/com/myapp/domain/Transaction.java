/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Table(name = "transaction")
@NoArgsConstructor
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private User buyer;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private User seller;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;

    @NotNull
    private boolean pieces;
    
    @NotNull
    private String state;


    @NotNull
    private Date date;

    @PrePersist
    protected void onCreate() {
        date = new Date();
    }

}
