package com.james.api.article;

import com.james.api.enums.ArticleRouter;

import java.sql.SQLException;
import java.util.Scanner;

public class ArticleView {
    public static void main(Scanner sc) throws SQLException {
        while(ArticleRouter.articleRouter(sc));
    }
}
