package com.rudevelopers.pos.dao.custome.impl;

import com.rudevelopers.pos.dao.custome.UserDao;
import com.rudevelopers.pos.entity.User;

import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean saveUser(User user) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(String email) {
        return false;
    }

    @Override
    public User findUser(String email) {
        return null;
    }

    @Override
    public List<User> findAllUser(User user) {
        return null;
    }
}
