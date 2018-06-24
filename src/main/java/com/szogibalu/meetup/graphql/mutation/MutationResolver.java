package com.szogibalu.meetup.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.szogibalu.meetup.graphql.author.Author;
import com.szogibalu.meetup.graphql.author.AuthorRepository;
import com.szogibalu.meetup.graphql.book.Book;
import com.szogibalu.meetup.graphql.book.BookInput;
import com.szogibalu.meetup.graphql.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MutationResolver implements GraphQLMutationResolver {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public MutationResolver(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Book addBook(BookInput bookInput) {
        Author author = authorRepository.saveAuthor(bookInput.getAuthor().get());
        Book book = bookInput.get();
        book.setAuthorId(author.getId());
        return bookRepository.saveBook(book);
    }


}
