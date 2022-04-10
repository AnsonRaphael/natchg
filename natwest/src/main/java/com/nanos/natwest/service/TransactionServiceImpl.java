package com.nanos.natwest.service;

import com.nanos.natwest.config.EncryptDecryptHelper;
import com.nanos.natwest.model.EncryptedQueueData;
import com.nanos.natwest.model.Transaction;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

@Service

public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private RestTemplate restTemplate;
    public static String QUEUE_API_URL="/api/v1/queue/";
    @Value("${com.nanos.queue.service.rest}")
    private String queueHost;
//    @Value("${com.nanos.queue.service.encrypt.key}")
//    private String mySecret;
//    private SecretKey secretKey;
//    private static byte[] key;

    @Override
    public void encryptAndSave(Transaction transaction) {
        System.out.println(transaction);
        String algorithm = "AES";
        String encryptReq = EncryptDecryptHelper.encrypt(transaction.toString());
            String response=restTemplate.postForObject(queueHost+QUEUE_API_URL,encryptReq,String.class);
    }

}
