package com.nanos.natwest.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nanos.natwest.config.EncryptDecryptHelper;
import com.nanos.natwest.entity.TransactionEntity;
import com.nanos.natwest.model.Transaction;
import com.nanos.natwest.repository.QueueRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.io.IOException;
import java.io.Serializable;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service
@RequiredArgsConstructor
public class QueueServiceImpl implements QueueService {
    @Autowired
    private QueueRepository queueRepository;
    @Override
    public void encryptAndSave(String transactionEncrypt) {
        TransactionEntity transactionEntity= new TransactionEntity();
        String transactionDeEncrypt = EncryptDecryptHelper.decrypt(transactionEncrypt);
        Transaction transaction = new Transaction();
        System.out.println(transactionDeEncrypt);
        JSONObject jsonObject = new JSONObject(transactionDeEncrypt);

            transaction = Transaction.builder()
                            .accountNumber(jsonObject.getString("accountNumber"))
                                    .amount(jsonObject.getString("amount"))
                                            .type(jsonObject.getString("type"))
                                                    .currency(jsonObject.getString("currency"))
                                                            .accountFrom(jsonObject.getString("accountFrom"))
                                                                    .build();

        BeanUtils.copyProperties(transaction,transactionEntity);
        queueRepository.save(transactionEntity);


    }
}
