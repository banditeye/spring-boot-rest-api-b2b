/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.service;

import com.myapp.domain.Basket;
import com.myapp.dto.PageParams;
import com.myapp.dto.ProductParams;
import java.util.List;

/**
 *
 * @author Kamil
 */
public interface BasketService {
    List<Basket> findByIdUser(PageParams pageParams);
    Basket addToBasket(Long id,Long pieces);
    
}
