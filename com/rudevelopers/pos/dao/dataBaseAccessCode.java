package com.rudevelopers.pos.dao;

import com.rudevelopers.pos.dto.CustomerDto;
import com.rudevelopers.pos.dto.UserDto;
import com.rudevelopers.pos.util.PasswordManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class dataBaseAccessCode {

    //========User Management===============
    public static boolean createUser(String email, String password) throws ClassNotFoundException, SQLException {

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

    //========User Management===============

    //========Customer Management===============

    public static boolean createCustomer(String email,String name,String contact,Double salary) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3307/mydb","root","1234");
        String sql="INSERT INTO customer VALUES (?,?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,email);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, contact);
        preparedStatement.setDouble(4, salary);

        return preparedStatement.executeUpdate()>0;


    }

    public static boolean updateCustomer(String email,String name,String contact,double salary) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3307/mydb","root","1234");
        String sql="UPDATE cutomer SET name=?, contact=?, salary=? WHERE email=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);

        preparedStatement.setString(1, name);
        preparedStatement.setString(2, contact);
        preparedStatement.setDouble(3, salary);
        preparedStatement.setString(4,email);
        return preparedStatement.executeUpdate()>0;

    }

    public static CustomerDto findCustomer(String email) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3307/mydb","root","1234");
        String sql="SELECT * FROM customer WHERE email=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);

        preparedStatement.setString(1,email);
        ResultSet resultSet=preparedStatement.executeQuery();

        if(resultSet.next()){
            return new CustomerDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4)
            );
        }
        return null;
    }

    public static boolean deleteCustomer(String email) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3307/mydb","root","1234");
        String sql="DELETE FROM customer WHERE email=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);


        preparedStatement.setString(1,email);
        return preparedStatement.executeUpdate()>0;
    }

    public static List<CustomerDto> findAllCustomers() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3307/mydb","root","1234");
        String sql="SELECT * FROM customer WHERE email=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery();

        List<CustomerDto> dto=new ArrayList<>();
        while(resultSet.next()){
            dto.add(new CustomerDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4)
            ));
        }
        return dto;
    }

    public static List<CustomerDto> searchCustomers(String searchText) throws ClassNotFoundException, SQLException {

        searchText="%"+searchText+"%";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3307/mydb","root","1234");
        String sql="SELECT * FROM customer WHERE email=? LIKE || name=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,searchText);
        preparedStatement.setString(2,searchText);
        ResultSet resultSet=preparedStatement.executeQuery();

        List<CustomerDto> dto=new ArrayList<>();
        while(resultSet.next()){
            dto.add(new CustomerDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4)
            ));
        }
        return dto;
    }



    //========Customer Management===============
}
