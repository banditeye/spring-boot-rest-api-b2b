/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.service;

import com.myapp.domain.Basket;
import com.myapp.domain.Product;
import com.myapp.domain.User;
import com.myapp.dto.PageParams;
import com.myapp.repository.BasketCustomRepository;
import com.myapp.repository.BasketRepository;
import com.myapp.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kamil
 */
@Service
public class BasketServiceImpl implements BasketService {
    
private final BasketCustomRepository basketCustomRepository;
private final SecurityContextService securityContextService;
private final ProductRepository productRepository;
private final BasketRepository basketRepository;

    @Autowired
        public BasketServiceImpl(BasketCustomRepository basketCustomRepository, SecurityContextService securityContextService, ProductRepository productRepository, BasketRepository basketRepository) {
        this.basketCustomRepository = basketCustomRepository;
        this.securityContextService = securityContextService;
        this.productRepository = productRepository;
        this.basketRepository = basketRepository;
    }



   


    @Override
    public List<Basket> findByIdUser(PageParams pageParams) {
        return securityContextService.currentUser().map(
                u-> basketCustomRepository.getByUserId(u, pageParams)
        ) .orElseThrow(RuntimeException::new);
    
      
        
    }


 
    @Override
    public Basket addToBasket(Long id, Long pieces) {
       Optional<User> user=securityContextService.currentUser();
       Optional<Product> product= productRepository.findById(id);
       Basket basket=new Basket(id, pieces, user.get(), product.get());
       return basketRepository.save(basket);
    }

   
    
}
