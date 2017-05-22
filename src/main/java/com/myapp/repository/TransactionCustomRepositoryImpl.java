/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.repository;

import com.myapp.domain.QTransaction;
import com.myapp.domain.QTransactionProducts;
import com.myapp.domain.QUser;
import com.myapp.domain.Transaction;
import com.myapp.domain.TransactionProducts;
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
public class TransactionCustomRepositoryImpl implements TransactionCustomRepository {
       private final JPAQueryFactory queryFactory;
        QTransaction qTransaction=QTransaction.transaction;
        QTransactionProducts qTransactionProducts=QTransactionProducts.transactionProducts;
       QUser qUser=QUser.user;

       @Autowired
    public TransactionCustomRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }
             
       
    @Override
    public List<Transaction> getTransactionByUser(User user, PageParams pageParams) {
       List<Transaction> list=queryFactory.selectFrom(qTransaction)
               .where(qTransaction.buyer.eq(user))
               .fetch();
       return list;
    }

    @Override
    public List<TransactionProducts> getTransactionProductsByTransaction(Transaction transaction, PageParams pageParams) {
        List<TransactionProducts> list=queryFactory.selectFrom(qTransactionProducts)
                .where(qTransactionProducts.transaction.eq(transaction))
                .fetch();
        return list;
    }

    @Override
    public List<TransactionProducts> getMySoldProduct(User user, PageParams pageParams) {
            List<TransactionProducts> list=queryFactory.selectFrom(qTransactionProducts)
                .where(qTransactionProducts.product.user.eq(user))
                .fetch();
        return list;
    }

 
    
    
  
}
