package com.rudevelopers.pos.dao.custome.impl;

import com.rudevelopers.pos.dao.custome.ProductDao;
import com.rudevelopers.pos.db.DbConnection;
import com.rudevelopers.pos.entity.Product;
import com.rudevelopers.pos.util.PasswordManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public boolean saveProduct(Product product) throws SQLException, ClassNotFoundException {

        String sql="INSERT INTO product VALUES (?,?)";
        PreparedStatement preparedStatement= DbConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setInt(1,product.getCode());
        preparedStatement.setString(2, product.getDescription());
        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public boolean updateProduct(Product product) throws ClassNotFoundException, SQLException {

        String sql="UPDATE product SET description=? WHERE code=? ";
        PreparedStatement preparedStatement= DbConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setString(1, product.getDescription());
        preparedStatement.setInt(2,product.getCode());
        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public boolean deleteProduct(int code) throws ClassNotFoundException, SQLException {

        String sql="DELETE product WHERE code=?";
        PreparedStatement preparedStatement= DbConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setInt(1,code);

        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public Product findProduct(int code) throws ClassNotFoundException, SQLException {


        String sql="SELECT FROM product WHERE code=?";
        PreparedStatement preparedStatement= DbConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setInt(1,code);

        ResultSet resultSet=preparedStatement.executeQuery();

        if(resultSet.next()){
            return new Product(resultSet.getInt(1),resultSet.getString(2));
        }else{
            return null;
        }


    }

    @Override
    public List<Product> findAllProduct(Product product) throws ClassNotFoundException, SQLException {

        String sql="SELECT * FROM product";
        PreparedStatement preparedStatement= DbConnection.getInstance().getConnection().prepareStatement(sql);


        ResultSet resultSet=preparedStatement.executeQuery();

        List<Product> productList=new ArrayList<>();
       while(resultSet.next()){
           productList.add(new Product(resultSet.getInt(1),resultSet.getString(2)));
       }
       return productList;
    }

    //==========================================EXTRA METHODS=============
    @Override
    public int getLastProductId() throws SQLException, ClassNotFoundException {


        String sql="SELECT code FROM product ORDER BY code DESC LIMIT 1 ";
        PreparedStatement preparedStatement= DbConnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery();

        if(resultSet.next()){
            return(resultSet.getInt(1)+1);
        }
        return 1;
    }



}
