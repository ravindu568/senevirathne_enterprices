package com.rudevelopers.pos.dao;

import com.rudevelopers.pos.dto.CustomerDto;
import com.rudevelopers.pos.dto.UserDto;

import com.rudevelopers.pos.dao.custome.CustomerDao;
import com.rudevelopers.pos.dao.custome.ProductDao;
import com.rudevelopers.pos.dao.custome.UserDao;
import com.rudevelopers.pos.dao.custome.impl.CustomerDaoImpl;
import com.rudevelopers.pos.dao.custome.impl.ProductDaoImpl;
import com.rudevelopers.pos.dao.custome.impl.UserDaoImpl;
import com.rudevelopers.pos.db.DbConnection;
import com.rudevelopers.pos.dto.UserDto;
import com.rudevelopers.pos.entity.Customer;
import com.rudevelopers.pos.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class dataBaseAccessCode {

   CustomerDao customerDao=new CustomerDaoImpl();
   UserDao userDao=new UserDaoImpl();
   ProductDao productDao=new ProductDaoImpl();

    public boolean createUser(String email, String password) throws SQLException, ClassNotFoundException {
        return userDao.saveUser(
                new User(email,password)
        );
    }



    public UserDto findUser(String email) throws ClassNotFoundException, SQLException {

        User user=userDao.findUser(email);

        if(user!=null){
            return new UserDto(
                 user.getEmail(),
                 user.getPassword()
            );

        }
        return null;
    }

    public boolean createCustomer(String email,String name,String contact,Double salary) throws ClassNotFoundException, SQLException {
        return customerDao.saveCustomer(
                new Customer(email,name,contact,salary)
        );



    }

    public boolean updateCustomer(String email,String name,String contact,double salary) throws ClassNotFoundException, SQLException {
       return customerDao.updateCustomer(
               new Customer(email,name,contact,salary)
       );

    }

    public boolean deleteCustomer(String email) throws ClassNotFoundException, SQLException {
       return customerDao.deleteCustomer(email);
    }

    public CustomerDto findCustomer(String email) throws ClassNotFoundException, SQLException {


        Customer customer=customerDao.findCustomer(email);


        if(customer!=null){
            return new CustomerDto(
                    customer.getEmail(),
                    customer.getName(),
                    customer.getContact(),
                    customer.getSalary()
            );
        }
        return null;
    }
    public  List<CustomerDto> findAllCustomers() throws ClassNotFoundException, SQLException {


        List<CustomerDto> dto=new ArrayList<>();

        for (Customer c:customerDao.findAllCustomer()){
            dto.add(new CustomerDto(
                    c.getEmail(),
                    c.getName(),
                    c.getContact(),
                    c.getSalary()));

        }

        return dto;
    }










}
