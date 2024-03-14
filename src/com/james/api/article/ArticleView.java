package com.james.api.article;

import java.sql.SQLException;
import java.util.Scanner;

public class ArticleView {
    public static void main(Scanner sc) throws SQLException {
        ArticleController articleController = new ArticleController();
        while (true){
            System.out.println("메뉴\n0-종료 1-글목록");

            switch (sc.next()) {
                case "0":
                    System.out.println("종료");return;
                case "1":
                    System.out.println("글목록");
                    articleController.findAll().forEach(i-> System.out.println(i));
                    break;
            }}
    }
}
