package com.rudevelopers.pos.dao.custome;

import com.rudevelopers.pos.entity.Customer;
import com.rudevelopers.pos.entity.User;

import java.util.List;

public interface UserDao {

    public boolean saveUser(User user);

    public boolean updateUser(User user);
    public boolean deleteUser(String email);
    public User findUser(String email);
    public List<User> findAllUser(User user);


}
