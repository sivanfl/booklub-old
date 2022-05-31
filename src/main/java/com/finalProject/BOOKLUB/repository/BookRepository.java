package com.finalProject.booklub.repository;

import com.finalProject.booklub.repository.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository <Book, Long>, JpaSpecificationExecutor <Book> {

    //@Query("SELECT s FROM book s WHERE s.Title=?1")
    Optional<Book> findByTitle(String title);
    List<Book> findBookByAuthorFirstName(String authorFirstName);
}
