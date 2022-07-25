package com.finalProject.booklub.logInUsers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/logInUsers")

public class logInUsersController {

    private final logInUsersService logInUsersService;
    private final logInUsersRepository logInUsersRepository;

    @Autowired
    public logInUsersController(logInUsersService usersService, logInUsersRepository usersRepository) {
        this.logInUsersService = usersService;
        this.logInUsersRepository = usersRepository;
    }


    @GetMapping
    public List<logInUsers> getUsers() {
        return logInUsersService.getUsers();
    }

    @PostMapping(consumes = {"application/json"})
    public void insertNewUser(@RequestBody logInUsers users) {
        logInUsersService.addNewUser(users);
    }

//    @DeleteMapping(path = "{username}")
//    public void deleteUsers(@PathVariable("username") logInUsers usersFullName) {
//        logInUsersService.deleteUser(usersFullName);
//    }

//    @PutMapping(path = "{id}")
//    public void updateUser(
//            @PathVariable("id") long id,
//            @RequestParam(required = false) String username,
//            @RequestParam(required = false) String password,
//            @RequestParam(required = false) Calendar cal,
//            @RequestParam(required = false) boolean isExpired,
//            @RequestParam(required = false) boolean isValid) {
//        logInUsersService.updateUser(id, username, password, cal, isExpired, isValid);
//    }
//}


//    @GetMapping("/find")
//    public Optional<Users> findUsersByFullName(
//            @Or({
//                    @Spec(params="FullName", path="title", spec = LikeIgnoreCase.class),
//                    @Spec(params="authorFirstName", path = "authorFirstName", spec = LikeIgnoreCase.class),
//                    @Spec(params="authorLastName", path = "authorLastName", spec = LikeIgnoreCase.class),
//                    @Spec(params="yearOfPublish", path = "yearOfPublish", spec = LikeIgnoreCase.class),
//                    @Spec(params="publisherName", path = "publisherName", spec = LikeIgnoreCase.class)
//            })
//            Specification<Users> bookSpec) {
//
//        return usersService.searchUser(bookSpec);
//    }


//    private static final List<Users> USERS = Arrays.asList(
//            new Users(1, "James Bond","jamesbond@gmail.com", "0564736756" ),
//            new Users(2, "Maria Jones","MariaJones@gmail.com", "0566786756"),
//            new Users(3, "Anna Smith","AnnaSmith@gmail.com", "0564456756")
//    );


}









