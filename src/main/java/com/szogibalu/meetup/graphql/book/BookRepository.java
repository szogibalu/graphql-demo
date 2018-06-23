package com.szogibalu.meetup.graphql.book;

import org.springframework.stereotype.Repository;

import java.util.Map;

import static com.google.common.collect.Maps.newConcurrentMap;

@Repository
public class BookRepository {

    private final Map<Integer, Book> books;

    public BookRepository() {
        this.books = newConcurrentMap();
        books.put(1, new Book(1, "The Lord of the Rings", 1));
    }

    public Iterable<Book> findAll() {
        return books.values();
    }

    public Book findById(int id) {
        return books.get(id);
    }


}
