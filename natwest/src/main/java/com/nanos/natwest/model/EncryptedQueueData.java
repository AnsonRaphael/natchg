package com.nanos.natwest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.crypto.SealedObject;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EncryptedQueueData {
    private SealedObject data;

}
