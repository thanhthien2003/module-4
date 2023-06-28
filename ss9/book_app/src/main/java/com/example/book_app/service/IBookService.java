package com.example.book_app.service;

import com.example.book_app.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    void save(Book book);
    void delete(Book book);
    Book findById(Integer id);
    boolean borrow(Integer id);
    void giveBack(Integer id);
}
