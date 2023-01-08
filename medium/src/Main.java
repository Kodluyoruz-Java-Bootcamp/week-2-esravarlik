import model.Article;
import model.Tag;
import model.User;
import service.ArticleService;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ArticleService articleService = new ArticleService();

        List<Tag> tags1 = new ArrayList<>();
        tags1.add(Tag.Culture);
        tags1.add(Tag.Books);

        List<Tag> tags2 = new ArrayList<>();
        tags2.add(Tag.DataScience);
        tags2.add(Tag.SoftwareDevelopment);
        tags2.add(Tag.ArtificialIntelligence);

        List<Tag> tags3 = new ArrayList<>();
        tags3.add(Tag.Education);
        tags3.add(Tag.Music);
        tags3.add(Tag.Poetry);
        tags3.add(Tag.Psychology);

        User user1 = new User("Esra", "esra@gmail.com", "password");
        User user2 = new User("Alp", "alp@gmail.com", "password");
        User user3 = new User("Ummuhan", "ummuhan@gmail.com", "password");

        UserService userService = new UserService();
        System.out.println("---------------------------");
        System.out.println("User Creation: ");
        userService.createUser(user1);
        userService.createUser(user2);
        userService.createUser(user3);

        userService.printAllUser();
        System.out.println("---------------------------");

        System.out.println("Article Creation: ");
        Article article1 = new Article("Title1", "Text", tags1, false, user1);
        Article article2 = new Article("Title2", "Text1", tags2, false, user2);
        Article article3 = new Article("Title3", "Text2", tags1, false, user3);
        Article article4 = new Article("Title4", "Text3", tags3, false, user1);

        articleService.createArticle(article1);
        articleService.createArticle(article2);
        articleService.createArticle(article3);
        articleService.createArticle(article4);
        System.out.println("---------------------------");

        System.out.println("Deleting An Article: ");
        articleService.deleteArticle(article3);

        System.out.println("---------------------------");
        System.out.println("Draft Article Creation: ");
        Article draftArticle1 = new Article("DraftTitle", "Text1", tags2, true, user3);
        articleService.createArticle(draftArticle1);


        user1.setFollowedUsers(List.of(user2, user3));
        user2.setFollowedUsers(List.of(user1));

        System.out.println("---------------------------");
        System.out.println("Users that " + user1.getUserName() + " follows: ");
        user1.getFollowedUsers().stream().forEach(user -> System.out.println(user.getUserName()));

        user1.setArticles(List.of(article1, article4));

        article1.setUser(user1);
        article2.setUser(user2);
        article4.setUser(user1);

        user1.setArticles(List.of(article1, article3));

        System.out.println("---------------------------");
        System.out.println("Listing " + user1.getUserName() + "'s blogs: ");
        articleService.printAll(articleService.getAllByArticle(user1));


        System.out.println("---------------------------");
        System.out.println("Tags followed by Esra: ");
        user1.setFollowedTags(List.of(Tag.ArtificialIntelligence, Tag.Love));
        System.out.println(user1.getFollowedTags());
        System.out.println("---------------------------");

    }
}