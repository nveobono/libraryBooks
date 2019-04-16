package com.nveob.daw.books.books.service;

import com.nveob.daw.books.books.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookServiceInterface {

    public List<Book> findAll();

    public Book findById(Long id);

    public void delete(Book book);

    public Book create(Book book);
}
