package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.sql.*;
import java.util.*;

@Controller
public class DataController {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/NewsAgency?useSSL=false&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "my-secret-pw";

    @GetMapping("/statti")
    public String showArticles(Model model) {
        System.out.println("Запрос статей..."); // Логирование
        List<Map<String, String>> articles = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("""
                SELECT a.title, a.text, au.name AS author 
                FROM articles a 
                JOIN authors au ON a.author_id = au.id
                """)) {

            while (rs.next()) {
                Map<String, String> article = new LinkedHashMap<>();
                article.put("title", rs.getString("title"));
                article.put("text", rs.getString("text"));
                article.put("author", rs.getString("author"));
                articles.add(article);
                System.out.println("Найдена статья: " + article); // Логирование
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при загрузке статей:");
            e.printStackTrace();
            model.addAttribute("error", "Ошибка базы данных: " + e.getMessage());
        }

        model.addAttribute("articles", articles);
        return "statti";
    }

    @GetMapping("/avtori")
    public String showAuthors(Model model) {
        System.out.println("Запрос авторов..."); // Логирование
        List<String> authors = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT name FROM authors")) {

            while (rs.next()) {
                String author = rs.getString("name");
                authors.add(author);
                System.out.println("Найден автор: " + author); // Логирование
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при загрузке авторов:");
            e.printStackTrace();
            model.addAttribute("error", "Ошибка базы данных: " + e.getMessage());
        }

        model.addAttribute("authors", authors);
        return "avtori";
    }
}