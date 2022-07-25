package com.finalProject.booklub.logInUsers;

import com.finalProject.booklub.users.Users;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "log_in_users")
public class logInUsers {

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
    @Column(name = "full_Name")
    String username;
    String password;
    boolean isValid;
    boolean isExpired;

    @OneToOne
    @MapsId
    @JoinColumn(name = "full_Name")
   private Users users;


    public logInUsers() {
    }


    public logInUsers(String username, String password,Calendar cal, boolean isValid, boolean isExpired) {
        this.username = username;
        this.password = password;
        this.isValid = isValid;
        this.isExpired = isExpired;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        return "logInUsers{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isValid=" + isValid +
                ", isExpired=" + isExpired +
                '}';
    }

}

