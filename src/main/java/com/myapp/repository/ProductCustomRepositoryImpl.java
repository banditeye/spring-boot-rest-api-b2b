/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.repository;

import com.myapp.domain.Category;
import com.myapp.domain.Product;
import com.myapp.domain.QCategory;
import com.myapp.domain.QProduct;
import com.myapp.domain.QSubcategory;
import com.myapp.domain.Subcategory;
import com.myapp.dto.PageParams;

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
    
    private final QProduct qProduct = QProduct.product;
    private final QSubcategory qSubcategory = QSubcategory.subcategory;
    private final QCategory qCategory=QCategory.category1;


    @Autowired
    public ProductCustomRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public List<Product> findBySubcategory(Subcategory subcategory, PageParams pageParams) {

        List<Product> list = queryFactory.selectFrom(qProduct)
                .where(
                        qProduct.subcategory.eq(subcategory))
                .fetch();

        return list;
    }

    /*
    select * from product p join subcategory sub, category cat where sub.category_id=cat.id and p.subcategory_id=sub.id and category_id=???
     */
    @Override
    public List<Product> findByCategory(Category category, PageParams pageParams) {
        List<Product> list =queryFactory.selectFrom(qProduct).from(qSubcategory).from(qCategory)
                .where(
                    qSubcategory.category.eq(category)
                        .and(qProduct.subcategory.eq(qSubcategory))
                        .and(qCategory.eq(category))
                    
                        
                ).fetch();
                return list;
    }

}
