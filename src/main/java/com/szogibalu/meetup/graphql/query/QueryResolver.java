package com.szogibalu.meetup.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.szogibalu.meetup.graphql.author.Author;
import com.szogibalu.meetup.graphql.author.AuthorRepository;
import com.szogibalu.meetup.graphql.book.Book;
import com.szogibalu.meetup.graphql.book.BookRepository;
import com.szogibalu.meetup.graphql.reader.Reader;
import com.szogibalu.meetup.graphql.reader.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;
import static com.google.common.collect.Sets.union;

@Component
public class QueryResolver implements GraphQLQueryResolver {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final ReaderRepository readerRepository;

    @Autowired
    public QueryResolver(BookRepository bookRepository, AuthorRepository authorRepository, ReaderRepository readerRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.readerRepository = readerRepository;
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

    public Iterable<Reader> listReaders() {
        return readerRepository.findAll();
    }

    public Iterable<?> listPersons() {
        Set<Reader> readers = newHashSet(readerRepository.findAll());
        Set<Author> authors = newHashSet(authorRepository.findAll());
        return union(readers, authors);
    }

}