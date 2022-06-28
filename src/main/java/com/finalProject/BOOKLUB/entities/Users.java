package com.finalProject.booklub.entities;

import javax.persistence.*;

@Entity
@Table(name = "users")
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
    long usersId;
    String fullName;
    String email;
    String phoneNumber;


    public Users() {
    }

    public Users(long usersId, String fullName, String email, String phoneNumber) {
        this.usersId = usersId;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }


    public Users(long usersId, String fullName, String email) {
        this.usersId = usersId;
        this.fullName = fullName;
        this.email = email;
    }


    public long getUsersId() {
        return usersId;
    }

    public void setUsersId(long usersId) {
        this.usersId = usersId;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + usersId +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}