package com.rudevelopers.pos.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static DbConnection dbConnection;
    private Connection connection;

    private DbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection= DriverManager.getConnection("jdbc:mysql://localhost:3307/mydb","root","1234");
    }

    public static DbConnection getInstance() throws SQLException, ClassNotFoundException {
        return (dbConnection==null)?dbConnection=new DbConnection():dbConnection;
    }

    public Connection getConnection(){
        return connection;
    }
}
