package com.finalProject.booklub.controller;

import com.finalProject.booklub.repository.entities.Book;
import com.finalProject.booklub.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/BOOKLUB")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks (){
        return bookService.getBooks();
    }


    @PostMapping(consumes = {"application/json"})
    public void insertNewBook(@RequestBody Book book){
        BookService.addNewBook(book);
    }
}
