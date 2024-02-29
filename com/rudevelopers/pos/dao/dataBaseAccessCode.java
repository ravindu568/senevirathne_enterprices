package com.rudevelopers.pos.dao;

import com.rudevelopers.pos.dto.UserDto;
import com.rudevelopers.pos.util.PasswordManager;

import java.sql.*;

public class dataBaseAccessCode {

    public static boolean createUser(String email,String password) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3307/mydb","root","1234");
        String sql="INSERT INTO user VALUES (?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,email);
        preparedStatement.setString(2, PasswordManager.encryptPassword(password));

        return preparedStatement.executeUpdate()>0;


    }

    public static UserDto findUser(String email) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3307/mydb","root","1234");
        String sql="SELECT * FROM user WHERE email=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,email);

        ResultSet set=preparedStatement.executeQuery();

        if(set.next()){
            return new UserDto(
                    set.getString(1),
                    set.getString(2)
            );

        }
        return null;
    }




}
