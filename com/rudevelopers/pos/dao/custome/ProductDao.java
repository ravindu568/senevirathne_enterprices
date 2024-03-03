package com.rudevelopers.pos.dao.custome;

import com.rudevelopers.pos.entity.Customer;
import com.rudevelopers.pos.entity.Product;

import java.util.List;

public interface ProductDao {

    public boolean saveProduct(Product product);

    public boolean updateProduct(Product product);
    public boolean deleteProduct(int code);
    public Product findProduct(int code);
    public List<Product> findAllProduct(Product product);

}
