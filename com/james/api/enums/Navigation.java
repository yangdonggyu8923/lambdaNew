package com.james.api.enums;

import com.james.api.article.ArticleView;
import com.james.api.crawler.CrawlerView;
import com.james.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum Navigation {

    Exit("x", scanner ->  {
        System.out.println("EXIT");
        return false;
    }),
    User("u", scanner -> {
        try {
            UserView.main(scanner);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    Board("b", scanner -> {
        System.out.println("Borad");
        return true;
    }),

    Account("m", scanner -> {
        System.out.println("Account");
        return true;
    }),
    Crawler("c", scanner-> {
        try {
            CrawlerView.main(scanner);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),

    Articles("a", scanner -> {
        try {
            ArticleView.main(scanner);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),

    ERROR("error", scanner-> {
        System.out.println("ERROR 유효하지 않는 문자입니다.");
        return true;
    });

    private final String name;
    private final Predicate<Scanner> predicate;

    Navigation(String name, Predicate<Scanner> predicate) {
        this.name = name;
        this.predicate = predicate;
    }
    public static boolean navigate(Scanner sc) {
        System.out.println("\n === x-Exit +" +
                "u-User " +
                "b-Board " +
                "m-Account " +
                "c-Crawler " +
                "a-Articles" +
                "===");
        String str = sc.next();
        return Stream.of(values())
                .filter(i -> i.name.equals(str))
                .findAny().orElse(ERROR).predicate.test(sc);
    }
}

