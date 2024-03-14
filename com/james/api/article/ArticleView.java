package com.james.api.article;

import java.sql.SQLException;
import java.util.*;

public class ArticleView {

    public static void main(Scanner sc) throws SQLException {

        ArticleController controller = new ArticleController();

        while (true) {
            System.out.println("[사용자메뉴]" + "0.종료\n" + "1.글 목록\n");
            switch (sc.next()) {
                case "0":
                    System.out.println("종료");
                    return;
                case "1":
                    System.out.println("글목록");
                    controller.findAll().forEach(i -> System.out.println(i));
                    break;
            }
        }
    }
}


