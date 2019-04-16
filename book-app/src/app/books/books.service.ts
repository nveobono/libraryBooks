import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable, throwError } from 'rxjs';
import { Book } from './book';
import { map, catchError } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
})
export class BooksService{

    private urlEndPoint: string = 'http://localhost:8080/api/libros';

    private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});

    constructor(private http: HttpClient, private router: Router){}

    getBooks(): Observable<Book[]>{
        return this.http.get(this.urlEndPoint).pipe(
            map(response => response as Book[])
        );
    }

    getBook(id): Observable<Book>{
        return this.http.get<Book>(`${this.urlEndPoint}/${id}`).pipe(
          catchError((e: any) =>{
            this.router.navigate(['/clientes']);
            return throwError(e);
          })
        )
      }

    create(book: Book): Observable<Book>{
        return this.http.post<Book>(this.urlEndPoint, book, {headers: this.httpHeaders}).pipe(
            map((response: any) => response.book as Book)
        );
    }

    update(book: Book): Observable<Book>{
        return this.http.put<Book>(`${this.urlEndPoint}/${book.id}`, book, {headers: this.httpHeaders}).pipe(
          map((response: any) => response.book as Book),
          catchError((e: any) =>{
            return throwError(e);
          })
        );  
      }
    
      delete(id){
        return this.http.delete<Book>(`${this.urlEndPoint}/${id}`, {headers: this.httpHeaders}).pipe(
          catchError((e: any) =>{
            return throwError(e);
          })
        );
      }

}