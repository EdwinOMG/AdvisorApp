package com.example.databasehelp;

import java.net.URI;
import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class DatabaseConnector {
    String URL = "jdbc:mysql://localhost:3306/STUDENT_MAJOR_SHEETS";
    String Username = "root";
    String Password = "password";
    Connection conn;

    public DatabaseConnector() throws SQLException {
        try (Connection connection = getConnection(URL,Username,Password)){

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) throws SQLException {

    }
}
