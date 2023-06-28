package com.example.book_app.service;

import com.example.book_app.model.Order;

import java.util.List;

public interface IOrderService {
    List<Order> findAll();
    void save(Order order);
    int randomCode();
    Order findByCode(int code);
    void delete(Order order);
}
