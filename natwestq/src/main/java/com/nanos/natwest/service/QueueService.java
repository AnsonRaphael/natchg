package com.nanos.natwest.service;

import javax.crypto.IllegalBlockSizeException;
import java.io.IOException;

public interface QueueService {

    void encryptAndSave(String transaction);
}
