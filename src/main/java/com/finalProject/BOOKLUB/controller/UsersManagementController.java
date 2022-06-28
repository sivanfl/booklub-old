package com.finalProject.booklub.controller;

import com.finalProject.booklub.entities.Users;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/users")
public class UsersManagementController {

    private static final List<Users> USERS = Arrays.asList(
            new Users(1, "James Bond","jamesbond@gmail.com", "0564736756" ),
            new Users(2, "Maria Jones","MariaJones@gmail.com", "0566786756"),
            new Users(3, "Anna Smith","AnnaSmith@gmail.com", "0564456756")
    );


//    hasRole('ROLE_') hasAnyRole('ROLE_') hasAuthority('permission') hasAnyAuthority('permission')

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<Users> getAllUsers() {
        System.out.println("getAllUsers");
        return USERS;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('user:write')")
    public void registerNewUser(@RequestBody Users users) {
        System.out.println("registerNewUser");
        System.out.println(users);
    }

    @DeleteMapping(path = "{usersId}")
    @PreAuthorize("hasAuthority('user:write')")
    public void deleteUser(@PathVariable("usersId") Long usersId) {
        System.out.println("deleteUsers");
        System.out.println(usersId);
    }

    @PutMapping(path = "{usersId}")
    @PreAuthorize("hasAuthority('user:write')")
    public void updateUser(@PathVariable("usersId") Long userId, @RequestBody Users user) {
        System.out.println("updateUser");
        System.out.println(String.format("%s %s", user.getUsersId(), user));
    }
}