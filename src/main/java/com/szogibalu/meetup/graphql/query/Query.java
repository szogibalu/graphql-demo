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

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Component
public class Query implements GraphQLQueryResolver {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final ReaderRepository readerRepository;

    @Autowired
    public Query(BookRepository bookRepository, AuthorRepository authorRepository, ReaderRepository readerRepository) {
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

    public Iterable listPersons() {
        List<Reader> readers = newArrayList(readerRepository.findAll());
        List<Author> authors = newArrayList(authorRepository.findAll());

        List list = newArrayList();
        list.addAll(readers);
        list.addAll(authors);

        return list;
    }

}