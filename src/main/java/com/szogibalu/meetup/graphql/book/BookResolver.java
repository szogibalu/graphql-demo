package com.szogibalu.meetup.graphql.book;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.szogibalu.meetup.graphql.author.Author;
import com.szogibalu.meetup.graphql.author.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookResolver implements GraphQLResolver<Book> {

    private final AuthorRepository authorRepository;

    @Autowired
    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author author(Book book) {
        return authorRepository.findById(book.getAuthorId());
    }

}