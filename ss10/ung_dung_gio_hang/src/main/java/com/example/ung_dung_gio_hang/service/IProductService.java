package com.example.ung_dung_gio_hang.service;

import com.example.ung_dung_gio_hang.model.Product;

import java.util.List;
import java.util.Map;

public interface IProductService {
    List<Product> findAll();
    Product findById(Integer id);
}
