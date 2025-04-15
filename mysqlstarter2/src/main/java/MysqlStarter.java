import java.sql.*;

public class MysqlStarter {
    private static final String DB_NAME = "NewsAgency";
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASSWORD = "my-secret-pw";

    public static void main(String[] args) {
        try {
            createDatabase();

            try (Connection conn = DriverManager.getConnection(URL + DB_NAME + "?useSSL=false", USER, PASSWORD);
                 Statement stmt = conn.createStatement()) {

                stmt.execute("CREATE TABLE IF NOT EXISTS authors (" +
                        "id INT AUTO_INCREMENT PRIMARY KEY, " +
                        "name VARCHAR(100))");

                stmt.execute("CREATE TABLE IF NOT EXISTS articles (" +
                        "id INT AUTO_INCREMENT PRIMARY KEY, " +
                        "title VARCHAR(200), " +
                        "text TEXT, " +
                        "author_id INT, " +
                        "FOREIGN KEY (author_id) REFERENCES authors(id))");

                stmt.execute("CREATE TABLE IF NOT EXISTS tags (" +
                        "id INT AUTO_INCREMENT PRIMARY KEY, " +
                        "name VARCHAR(100))");

                stmt.execute("CREATE TABLE IF NOT EXISTS article_tags (" +
                        "article_id INT, " +
                        "tag_id INT, " +
                        "FOREIGN KEY (article_id) REFERENCES articles(id), " +
                        "FOREIGN KEY (tag_id) REFERENCES tags(id), " +
                        "PRIMARY KEY (article_id, tag_id))");

                // сдеся пишем что хотип
                stmt.execute("INSERT IGNORE INTO authors(name) VALUES ('Alice'), ('Bob')");

                stmt.execute("INSERT IGNORE INTO articles(title, text, author_id) VALUES " +
                        "('News 1', 'Politics text', 1), " +
                        "('News 2', 'Technology text', 2)");

                stmt.execute("INSERT IGNORE INTO tags(name) VALUES ('Politics'), ('Technology'), ('Sports')");

                stmt.execute("INSERT IGNORE INTO article_tags(article_id, tag_id) VALUES " +
                        "(1, 1), (1, 2), (2, 2), (2, 3)");

                // вывод данных вроде правильно но мне внутренняя нейронка помогла
                try (ResultSet rs = stmt.executeQuery(
                        "SELECT a.title, a.text, au.name AS author, GROUP_CONCAT(t.name) AS tags " +
                                "FROM articles a " +
                                "JOIN authors au ON a.author_id = au.id " +
                                "LEFT JOIN article_tags at ON a.id = at.article_id " +
                                "LEFT JOIN tags t ON at.tag_id = t.id " +
                                "GROUP BY a.id")) {

                    // сделал эстетик вывод ну самому нравиттся
                    while (rs.next()) {
                        System.out.println("Заголовок: " + rs.getString("title"));
                        System.out.println("Текст: " + rs.getString("text"));
                        System.out.println("Автор: " + rs.getString("author"));
                        System.out.println("----------------");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // создание баззы
    private static void createDatabase() throws SQLException {
        try (Connection conn = DriverManager.getConnection(URL + "?useSSL=false", USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE DATABASE IF NOT EXISTS " + DB_NAME);
            System.out.println("База данных создана или уже существует: " + DB_NAME);
        }
    }
}