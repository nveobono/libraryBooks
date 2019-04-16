package com.nveob.daw.books.books.restController;

import com.nveob.daw.books.books.model.Book;
import com.nveob.daw.books.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
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

    @GetMapping("/libros/{id}")
    public Book getBook (@PathVariable Long id){
        return bookService.findById(id);
    }

    @DeleteMapping("/libros/{id}")
    public void delete(@PathVariable Long id){
        Book book = bookService.findById(id);
        bookService.delete(book);
    }

    @PostMapping("/libros")
    public Book create(Book book){
        return bookService.create(book);
    }

    @PutMapping("/libros/{id}")
    public Book update (@PathVariable Long id, Book book){
        Book actualBook = bookService.findById(id);

        actualBook.setBookAuthor(book.getBookAuthor());
        actualBook.setNameBook(book.getNameBook());
        actualBook.setBookDescription(book.getBookDescription());
        actualBook.setBookDate(book.getBookDate());

        return bookService.create(actualBook);
    }

}
