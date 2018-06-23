package com.szogibalu.meetup.graphql.reader;

import com.szogibalu.meetup.graphql.book.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reader {

    private int id;
    private String name;
    private List<Book> books;

}
