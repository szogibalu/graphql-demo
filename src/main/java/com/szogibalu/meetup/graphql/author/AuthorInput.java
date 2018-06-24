package com.szogibalu.meetup.graphql.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorInput {

    private String name;
    private String nationality;

    public Author get() {
        return new Author(null, name, nationality);
    }
}
