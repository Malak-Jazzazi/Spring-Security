package com.task.bookstore.service;

import com.task.bookstore.model.Book;
import com.task.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> listAllBooks(){
        return bookRepository.findAll();
    }
}
