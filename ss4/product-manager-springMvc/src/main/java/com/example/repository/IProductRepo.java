package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface IProductRepo {
    List<Product> display();
    boolean create(Product product);
    boolean delete(int id);
    boolean edit(Product product);
    List<Product> findByName(String name);
    Product getDetailProduct(int id);
    Product findById(int id);
}
