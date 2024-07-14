package main.utils;

import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@UtilityClass
public class DatabaseConnection {
    private static final String URL = "jdbc.url";
    private static final String USER = "jdbc.user";
    private static final String PASSWORD = "jdbc.password";

    static {
        try {
            Class.forName("jdbc.driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("PostgreSQL JDBC Driver not found.", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}