/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.dto;

import com.myapp.domain.Product;
import com.myapp.domain.Subcategory;
import lombok.Value;

/**
 *
 * @author Kamil
 */
@Value
public class ProductParams {

    String name;
    double price;
    String description;
    int pieces;
    int barcode;
    long idSubcategory;

   // public Product toProduct()
   // {
        //return new Product( name,  price,  description,  pieces,  barcode, subcategory);
    //}
}
