package com.example.rewardpoints.controller;

import com.example.rewardpoints.model.Transaction;
import com.example.rewardpoints.service.TransactionService;
import com.example.rewardpoints.service.RewardPointsCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RewardPointsController {

    @Autowired
    TransactionService transactionService;

    @Autowired
    RewardPointsCalculatorService rewardPointsCalculatorService;

    @GetMapping("/")
    public List<Transaction> getAllTransactions(){
        return transactionService.getAll();
    }

    @GetMapping("/user/{id}")
    public List<Transaction> getTransactionsbyCustomerId(@PathVariable Long id){
        return transactionService.getByUserId(id);
    }

    @GetMapping("/get-reward-points")
    public Float getRewardPointsByAmount(@RequestParam Float amount){
        return rewardPointsCalculatorService.calculateRewardPoints(amount);
    }


    @GetMapping("/get-reward-points-by-user-id/{userId}")
    public Float getRewardPointsByCustomerId(@PathVariable Long userId){
        return transactionService.getRewardPointsByUserId(userId);
    }


    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable Long id){
        return transactionService.getById(id);
    }

    @PostMapping("/")
    public void saveTransaction(Transaction transaction){
        transactionService.save(transaction);
    }


}
