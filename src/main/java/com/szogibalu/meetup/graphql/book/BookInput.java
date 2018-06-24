package com.szogibalu.meetup.graphql.book;

import com.szogibalu.meetup.graphql.author.AuthorInput;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookInput {

    private String name;
    private AuthorInput author;
    private int publicationYear;

    public Book get() {
        return new Book(null, name, null, publicationYear);
    }
}
