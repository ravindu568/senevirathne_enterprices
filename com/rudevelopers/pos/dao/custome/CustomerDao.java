package com.rudevelopers.pos.dao.custome;

import com.rudevelopers.pos.dto.CustomerDto;
import com.rudevelopers.pos.entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {

    public boolean saveCustomer(Customer customer) throws SQLException, ClassNotFoundException;

    public boolean updateCustomer(Customer customer) throws ClassNotFoundException, SQLException;
    public boolean deleteCustomer(String email) throws ClassNotFoundException, SQLException;
    public Customer findCustomer(String email) throws SQLException, ClassNotFoundException;
    public List<Customer> findAllCustomer(Customer customer) throws ClassNotFoundException, SQLException;

    //=====================extra methods==============
    public List<Customer> searchCustomer(String searchText) throws ClassNotFoundException, SQLException;

}
