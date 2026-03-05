package com.castro.DTO.GestaoEscolar.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    private static final String URL = "jdbc:mysql://localhost:3306/gestaoEscolar?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PW = "mysqlPW";

    public static Connection getConnetion() throws SQLException{
        return DriverManager.getConnection(URL,USER,PW);
    }
}
