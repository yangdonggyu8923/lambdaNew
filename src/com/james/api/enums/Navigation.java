package com.james.api.enums;

import com.james.api.account.AccountView;
import com.james.api.article.ArticleView;
import com.james.api.board.BoardView;
import com.james.api.crawler.CrawlerView;
import com.james.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public enum Navigation {
    EXIT("x", i -> {
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
        return true;})
    ;

    private final Predicate<Scanner> predicate;
    private final String name;

    Navigation(String name, Predicate<Scanner> predicate) {
        this.name = name;
        this.predicate = predicate;
    }



    public static boolean testNavigation(Scanner sc){
        System.out.println("x-Exit, b-Board, u-User, m-Account, c-Crawler, a-Article");
        String msg = sc.next();
        return Arrays.stream(values())
                .filter(i->i.name.equals(msg))
                .findFirst().orElseThrow(() ->new IllegalArgumentException("올바른 값이 아닙니다."))
                .predicate.test(sc);
    }
}