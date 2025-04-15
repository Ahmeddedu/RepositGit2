package edu.ithillel.course.sql.starter;

import java.sql.*;

public class MysqlStarter {
    private static String dbName = "demo_db";

    // private static final String URL = "jdbc:h2:tcp://localhost:9092/~/testdb"; //  ~/testdb.mv.db ~/testdb.mv.db
    private static final String URL = "jdbc:mysql://localhost:3306/"; //  ~/testdb.mv.db ~/testdb.mv.db
    //  private static final String URL = "jdbc:h2:tcp://localhost:9092/~/newnewtestdb"; //  ~/testdb.mv.db ~/testdb.mv.db
    private static final String USER = "root";
    private static final String PASSWORD = "my-secret-pw";


    public static void main(String[] args) throws SQLException {
        createDB();

        try (Connection conn = DriverManager.getConnection(URL + dbName + "?useSSL=false&allowPublicKeyRetrieval=true", USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

            stmt.execute("CREATE TABLE IF NOT EXISTS " +
                    "author" +
                    "(" +
                    "id  int NOT NULL  AUTO_INCREMENT," +
                    "name VARCHAR(100)," +
                    "PRIMARY KEY (id)" +
                    ")");
            stmt.execute("CREATE TABLE IF NOT EXISTS " +
                    "articles(" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    " title VARCHAR(100)," +
                    " author_id INT NOT NULL," +
                    " text VARCHAR(300)," +
                    " FOREIGN KEY (author_id) REFERENCES author(id))");

            stmt.execute("INSERT INTO author(name) VALUES ( 'Alice'), ( 'Bob')");

            ResultSet rs = stmt.executeQuery("SELECT * FROM author");

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createDB() throws SQLException {
        Connection conn = DriverManager.getConnection(URL + "?useSSL=false&allowPublicKeyRetrieval=true", USER, PASSWORD);
        Statement stmt = conn.createStatement();

        stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS demo_db");
        System.out.println("✅ Database created or already exists.");

        conn.close();
    }
}
