package com.finalProject.booklub.users;

import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/users")

public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
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
            @RequestParam(required = false) String fullName,
            @RequestParam(required = false) String phoneNumber,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String street,
            @RequestParam(required = false) String readingCategory,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String password) {
        usersService.updateUser(usersId, fullName, phoneNumber, email, city, street, readingCategory, username, password);
    }


    @GetMapping("/findUser")
    public Optional<Users> findUsers(
            @Or({
                    @Spec(params = "fullName", path = "fullName", spec = LikeIgnoreCase.class),
                    @Spec(params = "phoneNumber", path = "phoneNumber", spec = LikeIgnoreCase.class),
                    @Spec(params = "email", path = "email", spec = LikeIgnoreCase.class),
                    @Spec(params = "city", path = "city", spec = LikeIgnoreCase.class),
                    @Spec(params = "street", path = "street", spec = LikeIgnoreCase.class),
                    @Spec(params = "readingCategory", path = "readingCategory", spec = LikeIgnoreCase.class),
                    @Spec(params = "username", path = "username", spec = LikeIgnoreCase.class),
                    @Spec(params = "password", path = "password", spec = LikeIgnoreCase.class)
            })
            Specification<Users> usersSpec) {

        return usersService.searchUser(usersSpec);
    }

}








