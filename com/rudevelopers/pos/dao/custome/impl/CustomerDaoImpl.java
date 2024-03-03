package com.rudevelopers.pos.dao.custome.impl;

import com.rudevelopers.pos.dao.custome.CustomerDao;
import com.rudevelopers.pos.entity.Customer;

import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public boolean saveCustomer(Customer customer) {
        return false;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return false;
    }

    @Override
    public boolean deleteCustomer(String email) {
        return false;
    }

    @Override
    public Customer findCustomer(String email) {
        return null;
    }

    @Override
    public List<Customer> findAllCustomer(Customer customer) {
        return null;
    }
}
