package com.james.api.enums;

import com.james.api.account.AccountController;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum AccountRouter {
    Exit("x", scan -> {
        return false;
    }),
    Create("cat", scan -> {
        AccountController.getInstance().createAccount(scan);
        return true;
    }),
    Deposit("depo", scan -> {
        AccountController.getInstance().deposit(scan);
        return true;
    }),
    Withdraw("with", scan -> {
        AccountController.getInstance().withdraw(scan);
        return true;
    }),
    Balance("bal", scan -> {
        AccountController.getInstance().getBalance(scan);
        return true;
    }),
    RemoveAccount("rm", scan -> {
        AccountController.getInstance().delete(scan);
        return true;
    }),
    GetAccount("ls-a", scan -> {
        AccountController.getInstance().getAccounts(scan);
        return true;
    }),
    Wrong("WRONG", scan -> {
        System.out.println("WRONG");
        return true;
    }),
    CreateTable("touch", scan -> {
        return true;
    })
    ;
    private final String name;
    private final Predicate<Scanner> predicate;

    AccountRouter(String name, Predicate<Scanner> predicate) {
        this.name = name;
        this.predicate = predicate;
    }

    public static boolean menu(Scanner sc) {
        System.out.println("[Account] 0-Exit\n "
                + "1-create\n "
                + "2-Deposit\n "
                + "3-Withdraw\n "
                + "4-Balance\n"
                + "5-RemoveAccount\n ");
        String msg = sc.next();
        return Stream.of(values())
                .filter(i->i.name.equals(msg))
                .findAny().orElseGet(()->Wrong)
                .predicate.test(sc);
    }
}
