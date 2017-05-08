/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.repository;

import com.myapp.domain.Category;
import com.myapp.domain.QSubcategory;
import com.myapp.domain.Subcategory;
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
public class SubcategoryCustomRepositoryImpl implements SubcategoryCustomRepository {
   private final JPAQueryFactory queryFactory;
   QSubcategory qSubcategory=QSubcategory.subcategory;
   
   
   @Autowired
    public SubcategoryCustomRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }
   
   
    @Override
    public List<Subcategory> getByIdCategory(Category category) {
        List<Subcategory> list=queryFactory.selectFrom(qSubcategory)
                .where(qSubcategory.category.eq(category))
                .fetch();
        return list;
    }

    
        
}
