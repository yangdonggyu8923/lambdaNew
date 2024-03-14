package com.james.api.article;

import java.sql.SQLException;
import java.util.List;

public class ArticleController {
    private ArticleServiceImpl articleService;

    public ArticleController() {
        this.articleService = articleService.getInstance();
    }

    public List<?> findAll() throws SQLException {
        return articleService.findAll();
    }
}
