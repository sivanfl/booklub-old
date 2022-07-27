package com.finalProject.booklub.book;

import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/BOOKLUB")
public class BookController {

    private final BookService bookService;
    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookService bookService, BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping(consumes = {"application/json"})
    public void insertNewBook(@RequestBody Book book) {
        bookService.addNewBook(book);
    }

    @DeleteMapping(path = "{bookTitle}")
    public void deleteBook(@PathVariable("bookTitle") Book bookTitle) {
        bookService.deleteBook(bookTitle);
    }

    @PutMapping(path = "{bookId}")
    public void updateBook(
            @PathVariable("bookId") long bookId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String publisher) {
        bookService.updateBook(bookId, title, publisher);
    }


    @GetMapping("/find")
    public Optional<Book> findBook(
            @Or({
                    @Spec(params="title", path="title", spec = LikeIgnoreCase.class),
                    @Spec(params="authorFirstName", path = "authorFirstName", spec = LikeIgnoreCase.class),
                    @Spec(params="authorLastName", path = "authorLastName", spec = LikeIgnoreCase.class),
                    @Spec(params="yearOfPublish", path = "yearOfPublish", spec = LikeIgnoreCase.class),
                    @Spec(params="publisherName", path = "publisherName", spec = LikeIgnoreCase.class)
            })
            Specification<Book> bookSpec) {

        return bookService.searchBook(bookSpec);
    }



}
