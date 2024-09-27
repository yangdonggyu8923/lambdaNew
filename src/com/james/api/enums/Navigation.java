package com.james.api.enums;

import com.james.api.account.AccountView;
import com.james.api.article.ArticleView;
import com.james.api.board.BoardView;
import com.james.api.crawler.CrawlerView;
import com.james.api.menu.MenuController;
import com.james.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum Navigation {
    EXIT("x", i -> {
        System.out.println("EXIT");
        return false;}),
    BOARD("b", i -> {
        BoardView.main(i);
        return true;}),
    USER("u", i -> {
        try {
            UserView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;}),
    ACCOUNT("m", i -> {
        AccountView.main(i);
        return true;}),
    CRAWLER("c", i -> {
        try {
            CrawlerView.main(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;}),
    ARTICLE("a", i -> {
        try {
            ArticleView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;}),
    WRONG("WRONG", scan -> {
        System.out.println("WRONG");
        return true;
    });

    private final Predicate<Scanner> predicate;
    private final String name;

    Navigation(String name, Predicate<Scanner> predicate) {
        this.name = name;
        this.predicate = predicate;
    }



    public static boolean navi(Scanner sc) throws SQLException {
        System.out.println(MenuController.getInstance().selectTable());
        String msg = sc.next();
        return Stream.of(values())
                .filter(i->i.name.equals(msg))
                .findFirst().orElseGet(() -> WRONG)
                .predicate.test(sc);
    }
}