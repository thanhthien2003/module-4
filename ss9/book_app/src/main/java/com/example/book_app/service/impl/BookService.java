package com.example.book_app.service.impl;

import com.example.book_app.model.Book;
import com.example.book_app.repository.IBookRepository;
import com.example.book_app.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Book book) {

    }

    @Override
    public void delete(Book book) {

    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public boolean borrow(Integer id) {
        for (Book b: bookRepository.findAll()) {
            if (id== b.getId()){
                b.setQuantity(b.getQuantity()-1);
                if (b.getQuantity()<0){
                    return false;
                }
                bookRepository.save(b);
                break;
            }
        }
        return true;
    }

    @Override
    public void giveBack(Integer id) {
        for (Book b: bookRepository.findAll()) {
            if (id== b.getId()){
                b.setQuantity(b.getQuantity()+1);
                bookRepository.save(b);
                break;
            }
        }
    }
}
