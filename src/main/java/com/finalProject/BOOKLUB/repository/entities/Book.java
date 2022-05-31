package com.finalProject.booklub.repository.entities;

import javax.persistence.*;

@Entity
@Table
public class Book {
    @Id                                                 //creating a table of books
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )

        long id;                                        //entities of the book
        String title;
        String authorFirstName;
        String authorLastName;
        int yearOfPublish;
        String publisherName;

    public Book() {
    }

    public Book(String title, String authorFirstName, String authorLastName, int yearOfPublish, String publisherName) {
        this.title = title;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.yearOfPublish = yearOfPublish;
        this.publisherName = publisherName;
    }

    public Book(String title) {
        this.title = title;
    }

    public Book(String title, String authorFirstName) {
        this.title = title;
        this.authorFirstName = authorFirstName;
    }

    public Book(String title, String authorFirstName, String authorLastName) {
        this.title = title;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
    }

    public Book(String authorFirstName, String authorLastName, int yearOfPublish) {
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.yearOfPublish = yearOfPublish;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public void setYearOfPublish(int yearOfPublish) {
        this.yearOfPublish = yearOfPublish;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authorFirstName='" + authorFirstName + '\'' +
                ", authorLastName='" + authorLastName + '\'' +
                ", yearOfPublish=" + yearOfPublish +
                ", publisherName='" + publisherName + '\'' +
                '}';
    }

}





