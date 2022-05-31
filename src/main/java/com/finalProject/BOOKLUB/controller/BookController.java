package com.finalProject.booklub.controller;

import com.finalProject.booklub.BookSpec;
import com.finalProject.booklub.repository.entities.Book;
import com.finalProject.booklub.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/BOOKLUB")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {                        //connecting to the service layer
        this.bookService = bookService;
    }

    @GetMapping                                                          //return all books on the table
    public List<Book> getBooks (){
        return bookService.getBooks();
    }

    @PostMapping(consumes = {"application/json"})                       //insert new book to the table
    public void insertNewBook(@RequestBody Book book){
        BookService.addNewBook(book);
    }

    @DeleteMapping(path = "{bookTitle}")                                //deleting specific book
    public void deleteBook(@PathVariable("bookTitle") Book bookTitle){
        bookService.deleteBook(bookTitle);
    }

    @PutMapping(path = "{bookId}")                                      //update details of existing book in the table
    public void updateBook(
        @PathVariable("bookId") long bookId,
        @RequestParam(required = false) String title,
        @RequestParam(required = false) String publisher){
    bookService.updateBook(bookId,title,publisher);
        }


    @GetMapping(params = "title" )                                         //search API
    public Page<Book> findBook (BookSpec bookSpec, Pageable pageable) {
        return bookService.searchBook (bookSpec, pageable);
    }
}


