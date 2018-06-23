package com.szogibalu.meetup.graphql;

import com.coxautodev.graphql.tools.SchemaParserDictionary;
import com.szogibalu.meetup.graphql.author.Author;
import com.szogibalu.meetup.graphql.reader.Reader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    //      https://github.com/graphql-java/graphql-java-tools/issues/97
    @Bean
    public SchemaParserDictionary schemaParserDictionary() {
        return new SchemaParserDictionary()
                .add(Reader.class)
                .add(Author.class);
    }

}
