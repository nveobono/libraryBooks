package com.nveob.daw.books.books.repository;

import com.nveob.daw.books.books.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryBooks extends JpaRepository<Book, Long> {
}
