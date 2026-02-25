package com.example.tpmessagerie.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOUtil {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/messagerie";

    private static final String USER = "postgres";
    private static final String PASSWORD = "salma";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}