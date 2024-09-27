package com.james.api.account;

import com.james.api.enums.AccountRouter;

import java.util.Scanner;

public class AccountView {
    public static void main(Scanner sc) {

        while (AccountRouter.menu(sc));


//    private static void menu(Scanner sc, AccountController accountController) {
//        while (true) {
//
//            switch (sc.next()) {
//                case "0":
//                    System.out.println("Exit");
//                    return;
//                case "1":
//                    System.out.println("=== Create ===");
//                    System.out.println(accountController.createAccount(sc));
//                    break;
//                case "2":
//                    System.out.println("=== Deposit ===");
//                    System.out.println(accountController.deposit(sc));
//                    break;
//                case "3":
//                    System.out.println("=== Withdraw ===");
//                    System.out.println(accountController.withdraw(sc));
//                    break;
//                case "4":
//                    System.out.println("=== Balance ===");
//                    String temp = accountController.getBalance(sc);
//                    break;
//                case "5":
//                    System.out.println("=== Account List ===");
//                    System.out.println(accountController.getAccounts(sc));
//                case "6":
//                    System.out.println("=== Remove ===");
//                    System.out.println(accountController.delete(sc));
//                    break;
//
//            }
//        }
    }
 }
