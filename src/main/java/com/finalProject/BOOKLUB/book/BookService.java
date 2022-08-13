package com.finalProject.booklub.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookService{
    private static BookRepository bookRepository;

   @Autowired
    public  BookService(BookRepository bookRepository)  {
        this.bookRepository = bookRepository;
    }

    public static List<Book> getBooks() {
       return bookRepository.findAll();
        }

    public static void addNewBook(Book book) {
        Optional<Book> bookByOptional = bookRepository.findByTitle(book.getTitle());
        if(bookByOptional.isPresent()){
            throw new IllegalStateException("book already insert");
        }
        bookRepository.save(book);
    }

    public void deleteBook(Book book) {
       bookRepository.findByTitle(book.getTitle());
        boolean exists = bookRepository.existsById(book.getId());
        if(!exists){
            throw new IllegalStateException("The book does not exist");
        }
        bookRepository.deleteById(book.getId());
    }


    @Transactional
    public void updateBook(long id, Book book) {
        Book oldBook = bookRepository.findById(id).orElseThrow(() -> new IllegalStateException("the book is not exist"));
        book.setId(id);

        if (book.title != null && book.title.length() > 0 && !Objects.equals(oldBook.getTitle(), book.title)) {
            oldBook.setTitle(book.title);
        }

        if (book.authorFirstName != null && book.authorFirstName.length() > 0 && !Objects.equals(oldBook.getAuthorFirstName(), book.authorFirstName)) {
            oldBook.setAuthorFirstName(book.authorFirstName);
        }

        if (book.authorLastName != null && book.authorLastName.length() > 0 && !Objects.equals(oldBook.getAuthorLastName(), book.authorLastName)) {
            oldBook.setAuthorLastName(book.authorLastName);
        }

        if (book.yearOfPublish > 0 && (oldBook.getYearOfPublish()) != (book.yearOfPublish)) {
            oldBook.setYearOfPublish(book.yearOfPublish);
        }

        if (book.publisherName != null && book.publisherName.length() > 0 && !Objects.equals(oldBook.getPublisherName(), book.publisherName)) {
            oldBook.setPublisherName(book.publisherName);
        }

        bookRepository.save(book);
    }


    public Optional<Book> searchBook (Specification<Book> bookSpec) {
        return bookRepository.findOne(bookSpec);
        }

    public List<String> bookTitleAutocomplete(String term) {
        List<String> allBookTitle = new ArrayList<>();
        List<Book> bookList = BookService.getBooks();
        for (Book book : bookList){
            allBookTitle.add(book.getTitle());}
        return allBookTitle;
    }

}
