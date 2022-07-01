package com.digitalcity.advanced.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/dbslide";
    private static final String USER = "root";
    private static final String PW = "";

    public static Connection createConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PW);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
