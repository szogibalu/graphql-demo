package com.szogibalu.meetup.graphql.book;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Repository;

import java.util.Map;

import static com.google.common.collect.Maps.newConcurrentMap;

@Repository
public class BookRepository {

    private final Map<Integer, Book> books;

    public BookRepository() {
        this.books = newConcurrentMap();
        books.put(1, new Book(1, "The Lord of the Rings", 1, 1954));

        books.put(2, new Book(2, "Harry Potter and the Philosopher's Stone", 2, 1997));
        books.put(3, new Book(3, "Harry Potter and the Chamber of Secrets", 2, 1998));
        books.put(4, new Book(4, "Harry Potter and the Prisoner of Azkaban", 2, 1999));
        books.put(5, new Book(5, "Harry Potter and the Goblet of Fire", 2, 2000));
        books.put(6, new Book(6, "Harry Potter and the Order of the Phoenix ", 2, 2003));
        books.put(7, new Book(7, "Harry Potter and the Half-Blood Prince ", 2, 2005));
        books.put(8, new Book(8, "Harry Potter and the Deathly Hallows ", 2, 2007));
    }

    public Book saveBook(Book book) {
        Integer id = RandomUtils.nextInt();
        book.setId(id);
        this.books.put(id, book);
        return book;
    }

    ;

    public Iterable<Book> findAll() {
        return books.values();
    }

    public Book findById(int id) {
        return books.get(id);
    }


}
