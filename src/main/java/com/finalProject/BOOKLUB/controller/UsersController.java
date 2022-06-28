package com.finalProject.booklub.controller;

import com.finalProject.booklub.entities.Users;
import com.finalProject.booklub.repository.UsersRepository;
import com.finalProject.booklub.service.UsersService;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/users")

public class UsersController {



//    private static final List<Users> USERS = Arrays.asList(
//            new Users(1, "James Bond","jamesbond@gmail.com", "0564736756" ),
//            new Users(2, "Maria Jones","MariaJones@gmail.com", "0566786756"),
//            new Users(3, "Anna Smith","AnnaSmith@gmail.com", "0564456756")
//    );
//
//    @GetMapping
//    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
//    public List<Users> getAllUsers() {
//        System.out.println("getAllUsers");
//        return USERS;
//    }
//
//
//    @GetMapping(path = "{usersId}")
//    public Users getUsers(@PathVariable("usersId") Integer usersId) {
//        return USERS.stream()
//                .filter(users -> usersId.equals(users.getUsersId()))
//                .findFirst()
//                .orElseThrow(() -> new IllegalStateException(
//                        "Student " + usersId + " does not exists"
//                ));
//    }
//


    private final UsersService usersService;
    private final UsersRepository usersRepository;

    @Autowired
    public UsersController(UsersService usersService, UsersRepository usersRepository) {
        this.usersService = usersService;
        this.usersRepository = usersRepository;
    }


    @GetMapping
    public List<Users> getUsers() {
        return usersService.getUsers();
    }

    @PostMapping(consumes = {"application/json"})
    public void insertNewUser(@RequestBody Users users) {
        usersService.addNewUser(users);
    }

    @DeleteMapping(path = "{usersFullName}")
    public void deleteUsers(@PathVariable("usersFullName") Users usersFullName) {
        usersService.deleteUser(usersFullName);
    }

    @PutMapping(path = "{usersId}")
    public void updateUser(
            @PathVariable("usersId") long usersId,
            @RequestParam(required = false) String FullName,
            @RequestParam(required = false) String phoneNumber,
            @RequestParam(required = false) String email){
    usersService.updateUser(usersId, FullName,phoneNumber,email);
    }


    @GetMapping("/find")
    public Optional<Users> findUsersByFullName(
            @Or({
                    @Spec(params="FullName", path="title", spec = LikeIgnoreCase.class),
                    @Spec(params="authorFirstName", path = "authorFirstName", spec = LikeIgnoreCase.class),
                    @Spec(params="authorLastName", path = "authorLastName", spec = LikeIgnoreCase.class),
                    @Spec(params="yearOfPublish", path = "yearOfPublish", spec = LikeIgnoreCase.class),
                    @Spec(params="publisherName", path = "publisherName", spec = LikeIgnoreCase.class)
            })
            Specification<Users> bookSpec) {

        return usersService.searchUser(bookSpec);
    }
}












