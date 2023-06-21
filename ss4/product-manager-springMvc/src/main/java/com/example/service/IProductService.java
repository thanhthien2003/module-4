package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> display();
    boolean create(Product product);
    boolean delete(int id);
    boolean edit(Product product);
    List<Product> findByName(String name);
    Product getDetailProduct(int id);
    Product findById(int id);
}
