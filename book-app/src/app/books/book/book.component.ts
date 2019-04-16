import { Component, OnInit } from '@angular/core';
import { BooksService } from '../books.service';
import { Book } from '../book';
import { Router } from '@angular/router';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {

  private book: Book = new Book();
  public titulo: string = 'Nuevo Libro';

  constructor(private bookService: BooksService, private router: Router) { }

  ngOnInit() {
  }

  public create(): void{
    this.bookService.create(this.book).subscribe(
      (book : any) => {
        this.router.navigate(['/libros'])
      });
    console.log("ok")
    console.log(this.book);
  }

}
