package com.example.rewardpoints.service;

import com.example.rewardpoints.model.Transaction;

import java.util.List;

public interface TransactionService {

    Transaction getById(Long id);
    List<Transaction> getAll();
    List<Transaction> getByUserId(Long customerId);
    void save(Transaction transaction);
    Float getRewardPointsByUserId(Long customerId);
}
