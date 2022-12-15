package repository;

import model.Article;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {

    private static final List<Article> articleList = new ArrayList<>();

    public void createArticle(Article article) {
        articleList.add(article);
    }

    public void deleteArticle(Article article) {
        articleList.remove(article);
    }

    public List<Article> findAllArticle() {
        return articleList;
    }
}
