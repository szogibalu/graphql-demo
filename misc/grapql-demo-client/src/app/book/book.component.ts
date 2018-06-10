import {Component, OnInit} from '@angular/core';
import {Apollo} from 'apollo-angular';
import {Observable} from 'rxjs/Observable';
import {map} from 'rxjs/operators';
import gql from 'graphql-tag';
import {Book, Query} from '../types';

@Component({
  selector: 'book-list',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {
  books: Observable<Book[]>;

  constructor(private apollo: Apollo) {
  }

  ngOnInit() {
    this.books = this.apollo.watchQuery<Query>({
      query: gql`
        query books {
          books {
            name
            author {
              name
            }
          }
        }
      `
    })
    .valueChanges
    .pipe(
      map(result => result.data.books)
    );
  }
}
