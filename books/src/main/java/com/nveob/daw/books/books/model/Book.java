package com.nveob.daw.books.books.model;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nameBook;

    @Column(nullable = false, unique = true)
    private String bookAuthor;

    @Column()
    @Size(max = 100000)
    private String bookDescription;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date bookdate;

    public Book(){

    }

    public Book(String maneBook, String maneAuthor, String bookDascription, Date bookDate){
        this.nameBook = maneBook;
        this.bookAuthor = maneAuthor;
        this.bookDescription = bookDascription;
        this.bookdate = bookDate;
    }
    
    @PrePersist
    public void prePersist(){
        bookdate = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDascription) {
        this.bookDescription = bookDascription;
    }

    public Date getBookDate() {
        return bookdate;
    }

    public void setBookDate(Date bookDate) {
        this.bookdate = bookDate;
    }
}
