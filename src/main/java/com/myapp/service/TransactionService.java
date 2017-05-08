/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.service;

import com.myapp.domain.Transaction;
import com.myapp.dto.PageParams;
import java.util.List;

/**
 *
 * @author Kamil
 */
public interface TransactionService {
    void save();
    List<Transaction> myTransactionList(PageParams pageParams);
}
