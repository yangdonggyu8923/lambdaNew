package com.james.api.article;

import java.sql.SQLException;
import java.util.List;

public class ArticleController {
    private ArticleServiceImpl articleService;
    private static ArticleController instance = new ArticleController();

    public ArticleController() {
        this.articleService = articleService.getInstance();
    }

    public static ArticleController getInstance() {
        return instance;
    }

    public List<?> findAll() throws SQLException {
        return articleService.findAll();
    }
}
