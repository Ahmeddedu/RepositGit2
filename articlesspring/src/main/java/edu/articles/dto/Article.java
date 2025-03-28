package edu.articles.dto;

import org.bson.types.ObjectId;

public class Article {
    private ObjectId id;
    private String title;
    private String text;
    private boolean isPublished;
    private ObjectId authorId;

    public Article() {
    }

    public Article(String title, String text) {
        this.id = new ObjectId();
        this.title = title;
        this.text = text;
        this.isPublished = false;
    }

    public Article(String title, String text, ObjectId authorId) {
        this.id = new ObjectId();
        this.title = title;
        this.text = text;
        this.isPublished = false;
        this.authorId = authorId;
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

    public ObjectId getAuthorId() {
        return authorId;
    }

    public void setAuthorId(ObjectId authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "Стаття {" +
                "id=" + id +
                ", заголовок='" + title + '\'' +
                ", текст='" + (text.length() > 20 ? text.substring(0, 20) + "..." : text) +
                ", опубліковано=" + (isPublished ? "так" : "ні") +
                ", ID автора=" + authorId +
                '}';
    }
}