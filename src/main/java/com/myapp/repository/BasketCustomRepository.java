/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.repository;

import com.myapp.domain.Basket;
import com.myapp.domain.User;
import com.myapp.dto.PageParams;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Kamil
 */
public interface BasketCustomRepository {
    List<Basket> getByUserId(User user,PageParams pageParams);
    
}
