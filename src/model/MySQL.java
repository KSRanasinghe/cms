/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author KESHARA S.RANASINGHE
 */
public class MySQL {

    private static Connection connection;
    private static final String Database = "cafe";
    private static final String User = "root";
    private static final String Password = "8080";

    private static void init_DB() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/" + Database, User, Password);
    }

    public static void push(String sql) throws Exception {
        if (connection == null) {
            init_DB();
        }
        connection.createStatement().executeUpdate(sql);
    }

    public static ResultSet search(String sql) throws Exception {
        if (connection == null) {
            init_DB();
        }
        return connection.createStatement().executeQuery(sql);
    }

    public static Connection getDBConnection() throws Exception {
        if (connection == null) {
            init_DB();
        }
        return connection;
    }
}
