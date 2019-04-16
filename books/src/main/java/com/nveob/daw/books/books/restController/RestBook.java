package com.nveob.daw.books.books.restController;

import com.nveob.daw.books.books.model.Book;
import com.nveob.daw.books.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:4200"})
public class RestBook {

    @Autowired
    BookService bookService;

    @GetMapping("/libros")
    public List<Book> index(){
        return bookService.findAll();
    }

}
