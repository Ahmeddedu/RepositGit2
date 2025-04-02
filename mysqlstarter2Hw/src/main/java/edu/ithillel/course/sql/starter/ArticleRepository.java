package edu.ithillel.course.sql.starter;

import java.sql.*;

public class ArticleRepository {
    private static final String URL = "jdbc:h2:mem:testdb";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static Article getArticleWithAuthor(String articleTitle) {
        String query = "SELECT ar.title, ar.text, a.id, a.name " +
                "FROM articles ar " +
                "JOIN author a ON ar.author_id = a.id " +
                "WHERE ar.title = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, articleTitle);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Author author = new Author(rs.getInt("id"), rs.getString("name"));
                return new Article(rs.getString("title"), rs.getString("text"), author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Article article = getArticleWithAuthor("Java Basics");
        System.out.println(article);
    }
}
