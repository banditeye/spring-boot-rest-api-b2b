/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.repository;

import com.myapp.domain.Transaction;
import com.myapp.domain.User;
import com.myapp.dto.PageParams;
import java.util.List;

/**
 *
 * @author Kamil
 */
public interface TransactionCustomRepository {
    List<Transaction> getTransactionByUser(User user,PageParams pageParams);
}
