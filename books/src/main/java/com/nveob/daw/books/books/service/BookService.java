package com.nveob.daw.books.books.service;

import com.nveob.daw.books.books.model.Book;
import com.nveob.daw.books.books.repository.RepositoryBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements BookServiceInterface{

    @Autowired
    RepositoryBooks repositoryBooks;

    @Override
    public List<Book> findAll() {
        return repositoryBooks.findAll();
    }

    @Override
    public Book findById(Long id) {
        return repositoryBooks.findById(id).orElse(null);
    }

    @Override
    public void delete(Book book) {
        repositoryBooks.delete(book);
    }

    @Override
    public Book create(Book book) {
        return repositoryBooks.save(book);
    }
}
