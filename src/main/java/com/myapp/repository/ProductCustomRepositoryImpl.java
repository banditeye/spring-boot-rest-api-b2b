/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.repository;

import com.myapp.domain.Product;
import com.myapp.domain.QProduct;
import com.myapp.domain.Subcategory;
import com.myapp.dto.PageParams;
import com.myapp.dto.ProductDTO;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kamil
 */
@Repository
public class ProductCustomRepositoryImpl implements ProductCustomRepository {

    private final JPAQueryFactory queryFactory;
    private final QProduct qProduct=QProduct.product;
    
    @Autowired
    public ProductCustomRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public List<Product> findBySubcategory(Subcategory subcategory, PageParams pageParams) {
        
        List<Product> list=queryFactory.selectFrom(qProduct)
                .where(
                 qProduct.subcategory.eq(subcategory))
                .fetch();
        
        return list;
    }

}
