package com.example.rewardpoints.repository.impl;

import com.example.rewardpoints.model.Transaction;
import com.example.rewardpoints.model.User;
import com.example.rewardpoints.repository.TransactionRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

    private Map<Long, User> users = new ConcurrentHashMap<Long, com.example.rewardpoints.model.User>();
    private Map<Long, Transaction> transactions = new ConcurrentHashMap<>();

    public TransactionRepositoryImpl(){
        users.put(100L, new User(100L, "fname1", "lname1", 23, "address1", 500));
        users.put(101L, new User(101L, "fname2", "lname2", 45, "address2", 120));
        users.put(102L, new User(102L, "fname3", "lname3", 27, "address3", 2500));
        users.put(103L, new User(103L, "fname4", "lname4", 33, "address4", 70));
        users.put(104L, new User(104L, "fname5", "lname5", 21, "address5", 800));

        transactions.put(1L, new Transaction(1L, 100f, new Date(), users.get(100L)));
        transactions.put(2L, new Transaction(2L, 240f, new Date(), users.get(100L)));
        transactions.put(3L, new Transaction(3L, 30f, new Date(), users.get(100L)));
        transactions.put(4L, new Transaction(4L, 175f, new Date(), users.get(101L)));
        transactions.put(5L, new Transaction(5L, 80f, new Date(),  users.get(101L)));
        transactions.put(6L, new Transaction(6L, 1400f, new Date(), users.get(101L)));
        transactions.put(7L, new Transaction(7L, 140f, new Date(), users.get(101L)));
        transactions.put(8L, new Transaction(8L, 10f, new Date(), users.get(102L)));
        transactions.put(9L, new Transaction(9L, 150f, new Date(), users.get(103L)));
        transactions.put(10L, new Transaction(10L, 370f, new Date(),  users.get(104L)));
    }


    @Override
    public Transaction getById(Long id) {
        return transactions.get(id);
    }

    @Override
    public List<Transaction> getByCustomerId(Long userId) {
        return transactions.values().stream().filter(txn -> txn.getCreatedBy().getId() == userId).collect(Collectors.toList());
    }

    @Override
    public List<Transaction> getAll() {
        return transactions.values().stream().collect(Collectors.toList());
    }

    @Override
    public void save(Transaction transaction) {
        transactions.put(transaction.getTxnId(), transaction);
    }

}
