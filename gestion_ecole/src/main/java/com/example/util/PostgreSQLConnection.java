package com.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLConnection {

    private static Connection mockConnection;

    public static Connection getConnection() throws SQLException {
        if (mockConnection != null) {
            return mockConnection;
        }
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/java_gestion_project", "postgres", "0000");
    }

    public static void setMockConnection(Connection connection) {
        mockConnection = connection;
    }

    public static void clearMockConnection() {
        mockConnection = null;
    }
}
