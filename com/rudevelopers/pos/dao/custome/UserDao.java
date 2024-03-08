package com.rudevelopers.pos.dao.custome;

import com.rudevelopers.pos.entity.Customer;
import com.rudevelopers.pos.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    public boolean saveUser(User user) throws ClassNotFoundException, SQLException;

    public boolean updateUser(User user) throws ClassNotFoundException, SQLException;
    public boolean deleteUser(String email) throws ClassNotFoundException, SQLException;
    public User findUser(String email) throws ClassNotFoundException, SQLException;
    public List<User> findAllUser(User user) throws ClassNotFoundException, SQLException;


}
