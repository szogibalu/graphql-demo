package com.szogibalu.meetup.graphql.author;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Repository;

import java.util.Map;

import static com.google.common.collect.Maps.newConcurrentMap;

@Repository
public class AuthorRepository {

    private final Map<Integer, Author> authors;

    public AuthorRepository() {
        this.authors = newConcurrentMap();
        this.authors.put(1, new Author(1, "J.R. Tolkien", "British"));
        this.authors.put(2, new Author(2, "J. K. Rowling", "British"));
    }

    public Author findById(int id) {
        return authors.get(id);
    }

    public Iterable<Author> findAll() {
        return authors.values();
    }

    public Author saveAuthor(Author author) {
        Integer id = RandomUtils.nextInt();
        author.setId(id);
        this.authors.put(id, author);
        return author;
    }
}
