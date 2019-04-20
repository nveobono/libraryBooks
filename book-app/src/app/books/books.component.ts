import { Component, OnInit } from '@angular/core';
import { Book } from './book';
import { BooksService } from './books.service';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

  books: Book[];
  
  constructor(private bookService: BooksService) { }

  ngOnInit() {

    this.bookService.getBooks().subscribe(
      (books: any) => { this.books = books }
    )
  }

  delete(book: Book): void{
    this.bookService.delete(book.id).subscribe(
      reponse =>{
        this.books = this.books.filter(
          bok => bok !== book
        )
      }
    )
  }

}
