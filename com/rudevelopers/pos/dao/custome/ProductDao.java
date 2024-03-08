package com.rudevelopers.pos.dao.custome;

import com.rudevelopers.pos.entity.Customer;
import com.rudevelopers.pos.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {

    public boolean saveProduct(Product product) throws SQLException, ClassNotFoundException;

    public boolean updateProduct(Product product) throws ClassNotFoundException, SQLException;
    public boolean deleteProduct(int code) throws ClassNotFoundException, SQLException;
    public Product findProduct(int code) throws ClassNotFoundException, SQLException;
    public List<Product> findAllProduct(Product product) throws ClassNotFoundException, SQLException;

    public int getLastProductId() throws SQLException, ClassNotFoundException;

}
