package com.james.api.account;

import lombok.*;

import java.util.Date;

@ToString(exclude = {"id"})
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account {
    private Long id;
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private Date transactionDate;

    @Builder(builderMethodName = "builder")
    public Account(Long id, String accountNumber, String accountHolder, double balance, Date transactionDate) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.transactionDate = transactionDate;
    }
}