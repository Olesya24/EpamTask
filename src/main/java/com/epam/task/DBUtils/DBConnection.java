package com.epam.task.DBUtils;

import java.sql.*;

public class DBConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/Task3";
    private static final String USER = "postgres";
    private static final String PASS = "hhh56ggg";

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public static void close(AutoCloseable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
