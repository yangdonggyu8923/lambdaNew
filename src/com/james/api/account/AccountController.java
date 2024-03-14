package com.james.api.account;


import com.james.api.enums.Messenger;

import java.util.List;
import java.util.Scanner;

public class AccountController {
    AccountServiceImpl accountService;

    public AccountController() {
        this.accountService = AccountServiceImpl.getInstance();
    }


    public Messenger createAccount(Scanner sc) {
        System.out.println("아이디, 계좌번호, 계좌주, 잔고, 금일날짜를 입력하세요.");
        return accountService.save(Account.builder()
                .id(sc.nextLong())
                .accountNumber(sc.next())
                .accountHolder(sc.next())
                .balance(sc.nextDouble())
                .transactionDate(null)
                .build());
    }


    public String deposit(Scanner sc) {
        return accountService.deposit(Account.builder()
                .id(sc.nextLong())
                .accountNumber(sc.next())
                .accountHolder(sc.next())
                .balance(sc.nextDouble())
                .transactionDate(null)
                .build());
    }


    public String withdraw(Scanner sc) {
        return accountService.withdraw(Account.builder()
                .id(sc.nextLong())
                .accountNumber(sc.next())
                .accountHolder(sc.next())
                .balance(sc.nextDouble())
                .transactionDate(null)
                .build());
    }


    public String getBalance(Scanner sc) {
        return accountService.getBalance(sc.next());
    }


    public String delete(Scanner sc) {
        return accountService.delete(Account.builder().accountNumber(sc.next()).build());
    }

    public List<?> getAccounts(Scanner sc) {
        return accountService.findAll();
    }
}
