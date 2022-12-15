package model;

import java.util.List;

public class Article {

    private String title;

    private String content;

    private List<Tag> tags;

    private Boolean isDraft = false;

    private User user;

    public Article(String title, String content, List<Tag> tags, Boolean isDraft, User user) {
        this.title = title;
        this.content = content;
        this.tags = tags;
        this.isDraft = isDraft;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Boolean getDraft() {
        return isDraft;
    }

    public void setDraft(Boolean draft) {
        isDraft = draft;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
