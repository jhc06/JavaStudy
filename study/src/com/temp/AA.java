package com.temp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AA {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:{sql server}://@localhost:1521/test";
        String username = "C##TEST";
        String password = "oracle";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
        }
    }
}