/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.controller;

import com.myapp.domain.Basket;
import com.myapp.domain.Transaction;
import com.myapp.domain.TransactionProducts;
import com.myapp.dto.BasketParams;
import com.myapp.dto.PageParams;
import com.myapp.service.TransactionService;
import com.myapp.service.exceptions.NotPermittedException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Kamil
 */
@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    
    private TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    
    
      @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody void create() throws NotPermittedException {
      transactionService.save();
    }
    
        @RequestMapping(method = RequestMethod.GET, path = "/bought")
    public @ResponseBody List<Transaction> list(PageParams pageParams) {
        return transactionService.myTransactionList(pageParams);
    }
        @RequestMapping(method = RequestMethod.GET, path = "/products/{id}")
    public @ResponseBody List<TransactionProducts> list(@PathVariable("id") Long id,PageParams pageParams) {
        return transactionService.myTransactionProductList(id, pageParams);
    }
    
         @RequestMapping(method = RequestMethod.GET, path = "/sold")
    public @ResponseBody List<TransactionProducts> listtwo(PageParams pageParams) {
        return transactionService.mySoldProductList(pageParams);
    }
    
}
