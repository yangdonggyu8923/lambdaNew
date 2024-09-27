package com.james.api.enums;

import com.james.api.article.ArticleController;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum ArticleRouter {
    Exit("x", scan -> {
        System.out.println("EXIT");
        return false;
    }),
    List("l", scan -> {
        try {
            ArticleController.getInstance().findAll().forEach(i-> System.out.println(i));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    WRONG("WRONG", scan -> {
        System.out.println("WRONG");
        return true;
    })
    ;
    private final String name;
    private final Predicate<Scanner> predicate;

    ArticleRouter(String name, Predicate<Scanner> predicate) {
        this.name = name;
        this.predicate = predicate;
    }

    public static boolean articleRouter(Scanner sc) {
        System.out.println("[MENU]\nx-Exit\nl-List");
        String foo = sc.next();
        return Stream.of(values())
                .filter(i->i.name.equals(foo))
                .findAny().orElseGet(() -> WRONG)
                .predicate.test(sc);
    }
}
