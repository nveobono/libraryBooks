package com.nveob.daw.books.books.controller;

import com.nveob.daw.books.books.model.Book;
import com.nveob.daw.books.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping(value = "listaLibro")
    public String index(Model model){
        model.addAttribute("lista", "Mis Libros");
        model.addAttribute("libros", bookService.findAll());
        return "listaLibro";
    }
}
