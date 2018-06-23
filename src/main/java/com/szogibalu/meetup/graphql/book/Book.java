package com.szogibalu.meetup.graphql.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private int id;
    private String name;
    private int authorId;
    private int publicationYear;

}
