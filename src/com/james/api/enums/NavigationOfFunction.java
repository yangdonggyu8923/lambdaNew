package com.james.api.enums;

import com.james.api.account.AccountView;
import com.james.api.article.ArticleView;
import com.james.api.board.BoardView;
import com.james.api.crawler.CrawlerView;
import com.james.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Function;

public enum NavigationOfFunction {
    Exit("x", i -> "x"),
    User("u", i-> {
        try {
            UserView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }),
    Board("b", i -> {
            BoardView.main(i);
            return "";}),
    Account("m", i ->{
        AccountView.main(i);
        return "";
    }),
    Crawler("c", i -> {
        try {
            CrawlerView.main(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "";
    }),
    Article("a", i -> {
        try {
            ArticleView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }),

    ;

    private final String name;
    private final Function<Scanner, String> function;

    NavigationOfFunction(String name, Function<Scanner, String> function) {
        this.name = name;
        this.function = function;
    }

    public static String navi(Scanner sc) {
        System.out.println("x-Exit, b-Board, u-User, m-Account, c-Crawler, a-Article");
        String s = sc.next();
        System.out.println("입력값 :" + s);
        return s;
    }
}
