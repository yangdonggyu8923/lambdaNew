package com.james.api.enums;

import java.util.Scanner;
import java.util.function.Supplier;

public enum NavigationOfSupplier {
    ;

    NavigationOfSupplier(String name, Supplier<Scanner> supplier) {
        this.name = name;
        this.supplier = supplier;
    }

    private final String name;
    private final Supplier<Scanner> supplier;

    public static String navi(Scanner sc) {
        System.out.println("x-Exit, b-Board, u-User, m-Account, c-Crawler, a-Article");
        return "";
    }
}
