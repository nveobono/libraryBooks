package com.nveob.daw.books.books.bbdd;

import com.nveob.daw.books.books.model.Book;
import com.nveob.daw.books.books.repository.RepositoryBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
public class bbdd {

    @Autowired
    RepositoryBooks repositoryBooks;

    Date d1 = new Date(1999,12,31);

    @PostConstruct
    public void init(){



        Book b1 = new Book("La Biblia","Dios","", d1);
        repositoryBooks.save(b1);

        Book b2 = new Book("Guerra Espiritual","Juan Manuel","", d1);
        repositoryBooks.save(b2);

        Book b3 = new Book("Santidad","Mari Carmen","", d1);
        repositoryBooks.save(b3);

        Book b4 = new Book("Soberania de Dios","Ernesto Baltasar","", d1);
        repositoryBooks.save(b4);

        Book b5 = new Book("El poder de Dios","Antonio","", d1);
        repositoryBooks.save(b5);

        Book b6 = new Book("Las Bienaventuranzas","Jesus de Nazaret","", d1);
        repositoryBooks.save(b6);

        Book b7 = new Book("Dios Todo Poderoso","Pabol","", d1);
        repositoryBooks.save(b7);

        Book b8 = new Book("La venida de Criso","Pablo Tany","", d1);
        repositoryBooks.save(b8);

        Book b9 = new Book("El evangelio de Crsito", "Leslie Vicente", "Con este libro podras tener una gran idea sobre el proposito de la venida de Cristo al mundo, su muerte y la razón de su resurección, obteniendo gran conocimiento sobre los evangelios que demuestran la grandeza de Dios y su amor incondicional hacia el mundo.", d1);
        repositoryBooks.save(b9);
    }
}
