package com.nanos.natwest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction implements Serializable {
    private String accountNumber;
    private String type;
    private String amount;
    private String currency;
    private String accountFrom;

    @Override
    public String toString() {
        return "{" +
                "accountNumber:'" + accountNumber + '\'' +
                ", type:'" + type + '\'' +
                ", amount:'" + amount + '\'' +
                ", currency:'" + currency + '\'' +
                ", accountFrom:'" + accountFrom + '\'' +
                "}";
    }
}
