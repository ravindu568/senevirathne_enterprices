package com.rudevelopers.pos.dao.custome.impl;

import com.rudevelopers.pos.dao.custome.UserDao;
import com.rudevelopers.pos.db.DbConnection;
import com.rudevelopers.pos.dto.UserDto;
import com.rudevelopers.pos.entity.User;
import com.rudevelopers.pos.util.PasswordManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean saveUser(User user) throws ClassNotFoundException, SQLException {

        String sql="INSERT INTO user VALUES (?,?)";
        PreparedStatement preparedStatement= DbConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setString(1,user.getEmail());
        preparedStatement.setString(2, PasswordManager.encryptPassword(user.getPassword()));

        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public boolean updateUser(User user) throws ClassNotFoundException, SQLException {

        String sql="UPDATE user SET password=? WHERE email=? ";
        PreparedStatement preparedStatement= DbConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setString(1, PasswordManager.encryptPassword(user.getPassword()));
        preparedStatement.setString(2,user.getEmail());

        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public boolean deleteUser(String email) throws ClassNotFoundException, SQLException {

        String sql="DELETE user WHERE email=? ";
        PreparedStatement preparedStatement= DbConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setString(1,email);

        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public User findUser(String email) throws ClassNotFoundException, SQLException {

        String sql="SELECT * FROM user WHERE email=?";
        PreparedStatement preparedStatement= DbConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setString(1,email);

        ResultSet set=preparedStatement.executeQuery();

        if(set.next()){
            return new User(
                    set.getString(1),
                    set.getString(2)
            );

        }
        return null;
    }

    @Override
    public List<User> findAllUser(User user) throws ClassNotFoundException, SQLException {

        String sql="SELECT * FROM user";
        PreparedStatement preparedStatement= DbConnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet set=preparedStatement.executeQuery();

        List<User> userList=new ArrayList<>();
        if(set.next()){
            userList.add(new  User(
                    set.getString(1),
                    set.getString(2)
            ));

        }
        return userList;
    }
}
