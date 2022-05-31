package com.finalProject.booklub.service;

import com.finalProject.booklub.BookSpec;
import com.finalProject.booklub.repository.entities.Book;
import com.finalProject.booklub.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookService{
    private static BookRepository bookRepository;       //connecting to repository layer to use JpaRepository function

   @Autowired
    public BookService(BookRepository bookRepository)  {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {                                           //return all books in the table
       return bookRepository.findAll();
        }

    public static void addNewBook(Book book) {                               //insert new book to the table if not exist and save
        Optional<Book> bookByOptional = bookRepository.findByTitle(book.getTitle());
        if(bookByOptional.isPresent()){
            throw new IllegalStateException("book already insert");
        }
        bookRepository.save(book);
    }

    public void deleteBook(Book bookTitle) {                                //deleting existing book from the table
       bookRepository.findByTitle(bookTitle.getTitle());
        boolean exists = bookRepository.existsById(bookTitle.getId());
        if(!exists){
            throw new IllegalStateException("The book does not exist");
        }
        bookRepository.deleteById(bookTitle.getId());
    }

    @Transactional                                                         //update details of existing book in the table
    public void updateBook(long bookI, String title, String publisher){
       Book book = bookRepository.findById(bookI).orElseThrow(() -> new IllegalStateException("the book is not exist"));

       if (title != null && title.length() > 0 && !Objects.equals(book.getTitle(), title)){
           book.setTitle(title);
       }
        if (publisher != null && publisher.length()> 0 && !Objects.equals(book.getPublisherName(), publisher)){
            book.setPublisherName(publisher);
        }
    }

    public Page<Book> searchBook (BookSpec bookSpec, Pageable pageable)  {              //search API
        return bookRepository.findAll(bookSpec, pageable);
    }
}
