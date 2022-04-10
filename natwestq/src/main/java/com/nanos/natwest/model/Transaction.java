package com.nanos.natwest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {
    private String accountNumber;
    private String type;
    private String amount;
    private String currency;
    private String accountFrom;
}
