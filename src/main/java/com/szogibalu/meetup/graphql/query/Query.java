package com.szogibalu.meetup.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.szogibalu.meetup.graphql.author.Author;
import com.szogibalu.meetup.graphql.author.AuthorRepository;
import com.szogibalu.meetup.graphql.book.Book;
import com.szogibalu.meetup.graphql.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public Query(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Iterable<Book> listBooks() {
        return bookRepository.findAll();
    }

    public Iterable<Author> listAuthors() {
        return authorRepository.findAll();
    }

    public Book findBookById(int id) {
        return bookRepository.findById(id);
    }

}