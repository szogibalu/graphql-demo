package com.szogibalu.meetup.graphql.reader;

import com.szogibalu.meetup.graphql.book.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newConcurrentMap;

@Repository
public class ReaderRepository {

    private final Map<Integer, Reader> readers;

    private final BookRepository bookRepository;

    public ReaderRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        this.readers = newConcurrentMap();
        this.readers.put(1, new Reader(1, "Balázs Szögi", newArrayList(this.bookRepository.findAll())));
    }

    public Reader findById(int id) {
        return readers.get(id);
    }

    public Iterable<Reader> findAll() {
        return readers.values();
    }

}
