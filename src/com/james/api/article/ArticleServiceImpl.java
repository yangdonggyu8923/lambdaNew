package com.james.api.article;

import com.james.api.common.AbstractService;
import com.james.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ArticleServiceImpl extends AbstractService implements ArticleService {
    private ArticleRepository articleRepository;

    public ArticleServiceImpl() {
        this.articleRepository = articleRepository.getInstance();
    }

    private static ArticleServiceImpl instance = new ArticleServiceImpl();

    public static ArticleServiceImpl getInstance() {
        return instance;
    }

    @Override
    public Messenger save(Object o) {
        return null;
    }

    @Override
    public List findAll() throws SQLException {
        return articleRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return Optional.empty();
    }

    @Override
    public String count() {
        return null;
    }

    @Override
    public Optional getOne(String id) {
        return Optional.empty();
    }

    @Override
    public String delete(Object o) {
        return null;
    }

    @Override
    public Boolean existById(Long id) {
        return null;
    }
}
