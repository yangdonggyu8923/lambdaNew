package com.james.api.account;

import java.util.Scanner;

public class AccountView {
    public static void main(Scanner sc) {
        AccountController accountController = new AccountController();
        while (true) {
            System.out.println("[Menu]\n0-Exit\n" +
                    "1-Create\n" +
                    "2-Deposit\n" +
                    "3-Withdraw\n" +
                    "4-Balance\n" +
                    "5-AccountList\n"+
                    "6-Remove");
            switch (sc.next()) {
                case "0":
                    System.out.println("Exit");
                    return;
                case "1":
                    System.out.println("=== Create ===");
                    System.out.println(accountController.createAccount(sc));
                    break;
                case "2":
                    System.out.println("=== Deposit ===");
                    System.out.println(accountController.deposit(sc));
                    break;
                case "3":
                    System.out.println("=== Withdraw ===");
                    System.out.println(accountController.withdraw(sc));
                    break;
                case "4":
                    System.out.println("=== Balance ===");
                    String temp = accountController.getBalance(sc);
                    break;
                case "5":
                    System.out.println("=== Account List ===");
                    System.out.println(accountController.getAccounts(sc));
                case "6":
                    System.out.println("=== Remove ===");
                    System.out.println(accountController.delete(sc));
                    break;

            }
        }
    }
}
