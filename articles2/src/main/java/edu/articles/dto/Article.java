package edu.articles.dto;

import org.bson.types.ObjectId;

public class Article {
    private ObjectId id;
    private String title;
    private String text;
    private boolean isPublished;


    public Article() {
    }

    public Article(String title, String text) {
        this.id = new ObjectId();
        this.title = title;
        this.text = text;
        this.isPublished = false;
    }


    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public void setPublished(boolean published) {
        isPublished = published;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", isPublished=" + isPublished +
                '}';
    }
}