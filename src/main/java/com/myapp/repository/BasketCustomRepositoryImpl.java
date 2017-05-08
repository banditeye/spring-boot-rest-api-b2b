/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.repository;

import com.myapp.domain.Basket;
import com.myapp.domain.QBasket;
import com.myapp.domain.QProduct;
import com.myapp.domain.QUser;
import com.myapp.domain.User;
import com.myapp.dto.PageParams;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kamil
 */
@Transactional
@Repository
public class BasketCustomRepositoryImpl implements BasketCustomRepository {
    
        private final JPAQueryFactory queryFactory;
        QBasket qBasket=QBasket.basket;
       // QUser qUser=QUser.user;
        QProduct qProduct=QProduct.product;
                
    @Autowired
    public BasketCustomRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }
    
    /*
    SELECT * FROM basket bas join user us, product prod where bas.product_id=prod.id and bas.user_id=us.id and bas.user_id=1
    */
      @Override
    public List<Basket> getByUserId(User user, PageParams pageParams) {
        List<Basket> list=queryFactory.selectFrom(qBasket)
                .where(qBasket.user.eq(user) 
                
                )
                .fetch();
        return list;
    }
    
          @Override
    public List<Basket> getByUserId2(User user) {
        List<Basket> list=queryFactory.selectFrom(qBasket)
                .where(qBasket.user.eq(user) 
                
                )
                .fetch();
        return list;
    }
  
    @Override
    public void deleteByUser(User user) {
        queryFactory.delete(qBasket).where(qBasket.user.eq(user)).execute();
           
                
               
    }

    
}
