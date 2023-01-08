package service;

import model.Article;
import model.User;
import repository.ArticleRepository;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ArticleService {

    private final ArticleRepository articleRepository = new ArticleRepository();

    /**
     * Creates an article if the article title and article
     * content have more than three characters.
     *
     * @param article
     * @return void
     */
    public void createArticle(Article article) {
        if (article.getTitle().length() < 3 && article.getContent().length() < 3) {
            System.out.println("You must create a title and content. ");
        } else {
            articleRepository.createArticle(article);
            System.out.println("createArticle :: " + article.getTitle());
        }
    }

    /**
     * Deletes article.
     *
     * @param article
     * @return void
     */
    public void deleteArticle(Article article) {
        if (!article.getTitle().isEmpty()) {
            articleRepository.deleteArticle(article);
            System.out.println("deleteArticle :: " + article.getTitle());
        } else {
            System.out.println("The article is not available");
        }
    }

    public List<Article> getAllArticle() {
        return articleRepository.findAllArticle();
    }

    /**
     * Prints all articles.
     *
     * @param articleList
     * @return void
     */
    public void printAll(List<Article> articleList) {
        articleList.forEach(article -> System.out.println(article.getTitle()));
    }

    /**
     * Lists user articles.
     *
     * @param user
     * @return List<Article>
     */
    public List<Article> getAllByArticle(User user) {
        return getAllArticle().stream()
                .filter(article -> article.getUser().getUserName().equals(user.getUserName()))
                .collect(toList());
    }
}
