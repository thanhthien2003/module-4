package com.example.book_app.repository;

import com.example.book_app.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IOrderRepository extends JpaRepository<Order, Integer> {
    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM orders WHERE code = :code", nativeQuery = true)
    Order findByCode(@Param("code") int code);
}
