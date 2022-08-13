package com.finalProject.booklub.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository <Book, Long>, PagingAndSortingRepository <Book, Long>, JpaSpecificationExecutor <Book> {

    //@Query("SELECT s FROM book s WHERE s.Title=?1")
    Optional<Book> findByTitle(String title);


}
