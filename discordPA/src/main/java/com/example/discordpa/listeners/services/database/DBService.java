package com.example.discordpa.listeners.services.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//Database setup
public class DBService {

    private static final String url = "jdbc:mysql://localhost:3306/discordpa?serverTimezone = UTC";
    private static final String user = "root";
    private static final String password = "bigshark";


    public static Connection getMyConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
