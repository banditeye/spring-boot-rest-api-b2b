/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.controller;

import com.myapp.domain.Basket;
import com.myapp.domain.Micropost;
import com.myapp.dto.BasketParams;
import com.myapp.dto.MicropostParams;
import com.myapp.dto.PageParams;
import com.myapp.service.BasketService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Kamil
 */
@Controller
@RequestMapping("/api/basket")
public class BasketController {

    private final BasketService basketService;

    @Autowired
    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @RequestMapping(value = "/my", method = RequestMethod.GET)
    public @ResponseBody
    List<Basket> categoryList(PageParams pageParams) {
        return basketService.findByIdUser(pageParams);

    }
    
    
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Basket create(@RequestBody BasketParams basketParams) {
        return basketService.addToBasket(basketParams.getId(), basketParams.getPieces());
    }

}
