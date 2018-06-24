package com.szogibalu.meetup.graphql.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Integer id;
    private String name;
    private Integer authorId;
    private Integer publicationYear;

}
