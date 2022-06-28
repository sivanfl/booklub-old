package com.finalProject.booklub.entities;

import javax.persistence.*;

@Entity
@Table(name = "Log_In_User")
public class LogInUser {

    @Id                                                 //creating a table of login users
    @SequenceGenerator(
            name = "LogInUsers_sequence",
            sequenceName = "LogInUsers_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "LogInUsers_sequence"
    )
    long id;
    String userName;
    String password;
    String token;

    public LogInUser() {
    }

    public LogInUser(String userName, String password, String token) {
        this.userName = userName;
        this.password = password;
        this.token = token;
    }


    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "LogInUsers{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
