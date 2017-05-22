/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.service;

import com.myapp.domain.Basket;
import com.myapp.domain.Transaction;
import com.myapp.domain.TransactionProducts;
import com.myapp.domain.User;
import com.myapp.dto.PageParams;
import com.myapp.repository.BasketCustomRepository;
import com.myapp.repository.TransactionCustomRepository;
import com.myapp.repository.TransactionProductsRepository;
import com.myapp.repository.TransactionRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kamil
 */
@Service
public class TransactionServiceImpl implements TransactionService {
        private final SecurityContextService securityContextService;
        private final TransactionRepository transactionRepository;
        private final BasketCustomRepository basketCustomRepository;
        private final TransactionProductsRepository transactionProductsRepository;
        private final TransactionCustomRepository transactionCustomRepository;

        @Autowired
    public TransactionServiceImpl(TransactionCustomRepository transactionCustomRepository,SecurityContextService securityContextService, TransactionRepository transactionRepository, BasketCustomRepository basketCustomRepository, TransactionProductsRepository transactionProductsRepository) {
        this.securityContextService = securityContextService;
        this.transactionRepository = transactionRepository;
        this.basketCustomRepository = basketCustomRepository;
        this.transactionProductsRepository = transactionProductsRepository;
           this.transactionCustomRepository = transactionCustomRepository;
    }

   
    

    @Override
    public void save() {
            Optional<User> buyer=securityContextService.currentUser();
            List<Basket> basketList=basketCustomRepository.getByUserId2(buyer.get());    
            
            Transaction t=transactionRepository.save(new Transaction(buyer.get(), "rozpoczeta"));                                             

              List<TransactionProducts> tp = basketList.stream()
                    .map(p ->transactionProductsRepository.save( new TransactionProducts(transactionRepository.getOne(t.getId()),p.getProduct(),p.getPieces())))
                    .collect(Collectors.toList());
              
            
    }

    @Override
    public List<Transaction> myTransactionList(PageParams pageParams) {
            Optional<User> user=securityContextService.currentUser();
            return transactionCustomRepository.getTransactionByUser(user.get(), pageParams);
    }

    @Override
    public List<TransactionProducts> myTransactionProductList(Long id,PageParams pageParams) {
            Transaction transaction=transactionRepository.findOne(id);
            return transactionCustomRepository.getTransactionProductsByTransaction(transaction, pageParams);
    }

    @Override
    public List<TransactionProducts> mySoldProductList(PageParams pageParams) {
        Optional<User> user=securityContextService.currentUser();
        return transactionCustomRepository.getMySoldProduct(user.get(), pageParams);
    }







 
        
        
    
}
