package com.nanos.natwest.service;

import com.nanos.natwest.model.Transaction;

public interface TransactionService {

    void encryptAndSave(Transaction transaction);
}
