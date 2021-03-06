/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Kamil
 */

@Entity
@Table(name = "user_detail")
@NoArgsConstructor
@Data
public class UserDetail {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
            
    @NotNull
    @Column(name="company_name")
    private String companyName;
    
    @NotNull
    private int nip;
    
    @NotNull
    private int regon;
    
    @NotNull
    private boolean confirmed;
    
}
