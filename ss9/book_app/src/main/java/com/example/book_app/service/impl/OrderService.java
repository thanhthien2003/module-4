package com.example.book_app.service.impl;

import com.example.book_app.model.Order;
import com.example.book_app.repository.IOrderRepository;
import com.example.book_app.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public int randomCode() {
        Random random = new Random();
        int codeRandom = random.nextInt(90000) + 10000;
        if (findAll() != null) {
            for (Order o : findAll()) {
                while (codeRandom == o.getCode()) {
                    codeRandom = random.nextInt(90000) + 10000;
                }
            }
        }
        return codeRandom;
    }

    @Override
    public Order findByCode(int code) {
        return orderRepository.findByCode(code);
    }

    @Override
    public void delete(Order order) {
        orderRepository.delete(order);
    }
}
