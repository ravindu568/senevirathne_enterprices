package com.rudevelopers.pos.dao.custome.impl;

import com.rudevelopers.pos.dao.custome.CustomerDao;
import com.rudevelopers.pos.db.DbConnection;
import com.rudevelopers.pos.dto.CustomerDto;
import com.rudevelopers.pos.entity.Customer;
import com.rudevelopers.pos.entity.User;
import com.rudevelopers.pos.util.PasswordManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public boolean saveCustomer(Customer customer) throws SQLException, ClassNotFoundException {

        String sql="INSERT INTO customer VALUES (?,?,?,?)";
        PreparedStatement preparedStatement= DbConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setString(1,customer.getEmail());
        preparedStatement.setString(2,customer.getName());
        preparedStatement.setString(3,customer.getContact());
        preparedStatement.setDouble(4,customer.getSalary());
        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws ClassNotFoundException, SQLException {

        String sql="UPDATE user SET name=? contact=? salary=? WHERE email=? ";
        PreparedStatement preparedStatement= DbConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setString(1,customer.getName());
        preparedStatement.setString(2,customer.getContact());
        preparedStatement.setDouble(3,customer.getSalary());
        preparedStatement.setString(4,customer.getEmail());

        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public boolean deleteCustomer(String email) throws ClassNotFoundException, SQLException {


        String sql="DELETE FROM Customer WHERE email=?";
        PreparedStatement preparedStatement= DbConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setString(1,email);


        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public Customer findCustomer(String email) throws SQLException, ClassNotFoundException {

        String sql="SELECT * FROM user WHERE email=?";
        PreparedStatement preparedStatement= DbConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setString(1,email);

        ResultSet set=preparedStatement.executeQuery();

        if(set.next()){
            return new Customer(
                    set.getString(1),
                    set.getString(2),
                    set.getString(3),
                    set.getDouble(4)

            );

        }
        return null;
    }

    @Override
    public List<Customer> findAllCustomer(Customer customer) throws ClassNotFoundException, SQLException {

        String sql="SELECT * FROM user ";
        PreparedStatement preparedStatement= DbConnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet set=preparedStatement.executeQuery();

        List<Customer> customerList=new ArrayList<>();
        while (set.next()){
            customerList.add(
                    new Customer(
                            set.getString(1),
                            set.getString(2),
                            set.getString(3),
                            set.getDouble(4)

                    ));

        }

        return customerList;
    }

    @Override
    public List<Customer> searchCustomer(String searchText) throws ClassNotFoundException, SQLException {
        searchText="%"+searchText+"%";


        String sql="SELECT * FROM customer WHERE email=? LIKE || name=?";
        PreparedStatement preparedStatement= DbConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setString(1,searchText);
        preparedStatement.setString(2,searchText);
        ResultSet resultSet=preparedStatement.executeQuery();

        List<Customer> customer=new ArrayList<>();
        while(resultSet.next()){
            customer.add(new Customer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4)
            ));
        }
        return customer;
    }
}
