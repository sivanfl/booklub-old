package com.finalProject.booklub.users;

import javax.persistence.*;

@Entity
@Table(name = "users")
@SecondaryTable(name= "log_in_users", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id"))
public class Users {

    @Id
    @SequenceGenerator(
            name = "users_sequence",
            sequenceName = "users_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "users_sequence"
    )
    long id;
    String fullName;
    String email;
    String phoneNumber;
    String city;
    String street;
    String readingCategory;

    @Column (name = "username", table = "log_in_users")
    String username;
    @Column (name = "password", table = "log_in_users")
    String password;
    @Column (name = "is_Valid", table = "log_in_users")
    boolean isValid;
    @Column (name = "is_Expired", table = "log_in_users")
    boolean isExpired;


    public Users(){
    }

    public Users(String fullName, String email, String phoneNumber, String city, String street, String readingCategory, String username, String password) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.street = street;
        this.readingCategory = readingCategory;
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getReadingCategory() {
        return readingCategory;
    }

    public void setReadingCategory(String readingCategory) {
        this.readingCategory = readingCategory;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", readingCategory='" + readingCategory + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isValid=" + isValid +
                ", isExpired=" + isExpired +
                '}';
    }
}
