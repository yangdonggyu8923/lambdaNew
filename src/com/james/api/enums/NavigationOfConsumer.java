package com.james.api.enums;

import java.util.Scanner;
import java.util.function.Consumer;

public enum NavigationOfConsumer {
    ;
    private final String name;
    private final Consumer<Scanner> consumer;

    NavigationOfConsumer(String name, Consumer<Scanner> consumer) {
        this.name = name;
        this.consumer = consumer;
    }

    public static String navi(Scanner sc) {
        System.out.println("x-Exit, b-Board, u-User, m-Account, c-Crawler, a-Article");
        return "";
    }
}
