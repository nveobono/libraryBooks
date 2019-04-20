import { Component, OnInit } from '@angular/core';
import { BooksService } from '../books.service';
import { Book } from '../book';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {

  private book: Book = new Book();
  public titulo: string = 'Nuevo Libro';

  constructor(private bookService: BooksService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.getBookid()
  }

  public getBookid(): void{
    this.activatedRoute.params.subscribe(
      (params: any) => {
        let id = params['id']
        if(id){
          this.bookService.getBook(id).subscribe(
            (book: any) => this.book = book
          )
        }
      }
    )
  }

  public create(): void{
    this.bookService.create(this.book).subscribe(
      (book : any) => {
        this.router.navigate(['/libros'])
      });
    console.log("ok")
    console.log(this.book);
  }

  public update(): void{
    this.bookService.update(this.book).subscribe(
      (book: any) => {
        this.router.navigate(['/libros'])
      }
    )
  }

}
