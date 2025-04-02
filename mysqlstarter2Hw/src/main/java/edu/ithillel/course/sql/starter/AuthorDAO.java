package edu.ithillel.course.sql.starter;

import java.sql.*;

public class AuthorDAO {
    private static final String URL = "jdbc:h2:mem:testdb";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static Author getAuthorWithArticles(int authorId) {
        String query = "SELECT a.id, a.name, ar.title, ar.text " +
                "FROM author a " +
                "LEFT JOIN articles ar ON a.id = ar.author_id " +
                "WHERE a.id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, authorId);
            ResultSet rs = stmt.executeQuery();

            Author author = null;
            while (rs.next()) {
                if (author == null) {
                    author = new Author(rs.getInt("id"), rs.getString("name"));
                }
                String title = rs.getString("title");
                String text = rs.getString("text");
                if (title != null) {
                    author.addArticle(new Article(title, text, author));
                }
            }
            return author;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Author author = getAuthorWithArticles(1);
        System.out.println(author);
    }
}
