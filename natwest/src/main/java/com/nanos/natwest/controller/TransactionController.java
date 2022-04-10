package com.nanos.natwest.controller;

import com.nanos.natwest.model.Transaction;
import com.nanos.natwest.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transaction")
@AllArgsConstructor
public class TransactionController {
    private TransactionService transactionService;

    @PostMapping
    public void addTransaction(@RequestBody Transaction transaction){
        transactionService.encryptAndSave(transaction);

    }

}
