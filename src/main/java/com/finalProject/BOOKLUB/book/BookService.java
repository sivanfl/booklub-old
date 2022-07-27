package com.finalProject.booklub.book;

import com.finalProject.booklub.book.Book;
import com.finalProject.booklub.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookService{
    private static BookRepository bookRepository;

   @Autowired
    public BookService(BookRepository bookRepository)  {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
       return bookRepository.findAll();
        }

    public static void addNewBook(Book book) {
        Optional<Book> bookByOptional = bookRepository.findByTitle(book.getTitle());
        if(bookByOptional.isPresent()){
            throw new IllegalStateException("book already insert");
        }
        bookRepository.save(book);
    }

    public void deleteBook(Book bookTitle) {
       bookRepository.findByTitle(bookTitle.getTitle());
        boolean exists = bookRepository.existsById(bookTitle.getId());
        if(!exists){
            throw new IllegalStateException("The book does not exist");
        }
        bookRepository.deleteById(bookTitle.getId());
    }

    @Transactional
    public void updateBook(long bookI, String title, String publisher){
       Book book = bookRepository.findById(bookI).orElseThrow(() -> new IllegalStateException("the book is not exist"));

       if (title != null && title.length() > 0 && !Objects.equals(book.getTitle(), title)){
           book.setTitle(title);
       }
        if (publisher != null && publisher.length()> 0 && !Objects.equals(book.getPublisherName(), publisher)){
            book.setPublisherName(publisher);
        }
    }


    public Optional<Book> searchBook (Specification<Book> bookSpec) {
        return bookRepository.findOne(bookSpec);
        }

}
