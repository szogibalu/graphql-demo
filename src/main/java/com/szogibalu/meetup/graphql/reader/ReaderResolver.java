package com.szogibalu.meetup.graphql.reader;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.szogibalu.meetup.graphql.book.Book;
import com.szogibalu.meetup.graphql.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReaderResolver implements GraphQLResolver<Reader> {

    private final BookRepository bookRepository;

    @Autowired
    public ReaderResolver(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> books(Reader reader) {
        return reader.getBooks();
    }


}
