package com.james.api.account;

public class AccountRepository{
    private static AccountRepository instance = new AccountRepository();

    public static AccountRepository getInstance() {
        return instance;
    }


    public String deposit(Account account) {
        return null;
    }


    public String withdraw(Account account) {
        return null;
    }


    public String getBalance(String accountNumber) {
        return null;
    }
}
