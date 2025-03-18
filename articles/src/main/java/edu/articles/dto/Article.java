package edu.articles.dto;

import org.bson.types.ObjectId;

public class Article {
    private ObjectId id;  // Унікальний ідентифікатор статті
    private String title;  // Заголовок статті
    private String text;   // Текст статті

    // Конструктори
    public Article() {
    }

    public Article(String title, String text) {
        this.id = new ObjectId();  // Генеруємо новий ідентифікатор
        this.title = title;
        this.text = text;
    }

    // Геттери та сеттери
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

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}