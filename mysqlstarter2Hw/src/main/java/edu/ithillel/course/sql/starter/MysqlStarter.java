package edu.ithillel.course.sql.starter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MysqlStarter {
    // private static final String URL = "jdbc:h2:tcp://localhost:9092/~/testdb"; //  ~/testdb.mv.db ~/testdb.mv.db
    private static final String URL = "jdbc:h2:tcp://localhost:9092/~/newtestdb"; //  ~/testdb.mv.db ~/testdb.mv.db
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

            // stmt.execute("DROP TABLE articles");
            // stmt.execute("DROP TABLE author");

            stmt.execute("CREATE TABLE " +
                    "author" +
                    "(" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(100)" +
                    ")");
            stmt.execute("CREATE TABLE " +
                    "articles(" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    " title VARCHAR(100)," +
                    " author_id INT NOT NULL," +
                    " text VARCHAR(300)," +
                    " FOREIGN KEY (author_id) REFERENCES author(id))");
            stmt.execute("CREATE TABLE Dragons (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(100) NOT NULL," +
                    "age INT," +
                    "color VARCHAR(50)," +
                    "element VARCHAR(50))");

            ResultSet rs = stmt.executeQuery("SELECT * FROM author");

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}