package com.nanos.natwest.controller;

import com.nanos.natwest.model.Transaction;
import com.nanos.natwest.service.QueueService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/queue")
@AllArgsConstructor
public class QueueController {
    private QueueService queueService;

    @PostMapping
    public void addTransactionToQueue(@RequestBody String data){
        queueService.encryptAndSave(data);

    }

}
