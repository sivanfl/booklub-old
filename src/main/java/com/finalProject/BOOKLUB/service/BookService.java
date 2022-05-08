package com.finalProject.booklub.service;

import com.finalProject.booklub.repository.entities.Book;
import com.finalProject.booklub.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService{
    private final BookRepository bookRepository;


   /**-
    @param xyz
     **/
   @Autowired
    public BookService(BookRepository bookRepository)  {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
       return bookRepository.findAll();
        }

    public static void addNewBook(Book book) {
        System.out.println(book);
    }

}
