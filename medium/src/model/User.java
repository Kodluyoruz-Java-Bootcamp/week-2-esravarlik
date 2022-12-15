package model;

import java.util.List;

public class User {

    private String userName;

    private String email;

    private String password;

    private List<Article> articles;

    private List<User> followedUsers;

    private List<Tag> followedTags;

    public User() {
    }

    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<User> getFollowedUsers() {
        return followedUsers;
    }

    public void setFollowedUsers(List<User> followedUsers) {
        this.followedUsers = followedUsers;
    }

    public List<Tag> getFollowedTags() {
        return followedTags;
    }

    public void setFollowedTags(List<Tag> followedTags) {
        this.followedTags = followedTags;
    }
}
