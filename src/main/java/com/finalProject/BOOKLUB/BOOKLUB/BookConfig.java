package com.finalProject.BOOKLUB.BOOKLUB;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner CommandLineRunner (BookRepository bookRepository){
        return args -> {
            Book book = new Book(
                    "Alice's Adventures in Wonderland",
                    "Jon",
                    "Krakauer",
                    1997,
                    "puffin books"
                    );

            Book book1 = new Book(
                    "Into Thin Air",
                    "Lewis",
                    "Carroll",
                    1997,
                    "anchor books"
            );

            bookRepository.saveAll(
                    List.of(book , book1)
            );
        };
    }

}
