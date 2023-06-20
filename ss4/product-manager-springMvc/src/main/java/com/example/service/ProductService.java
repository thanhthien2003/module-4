package com.example.service;

import com.example.model.Product;
import com.example.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepo productRepo;

    @Override
    public List<Product> display() {
        return productRepo.display();
    }

    @Override
    public boolean create(Product product) {
        return productRepo.create(product);
    }

    @Override
    public boolean delete(int id) {
        return productRepo.delete(id);
    }

    @Override
    public boolean edit(Product product) {
        return productRepo.edit(product);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepo.findByName(name);
    }

    @Override
    public Product getDetailProduct(int id) {
        return productRepo.getDetailProduct(id);
    }
}
