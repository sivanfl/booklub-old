package com.finalProject.booklub.service;

import com.finalProject.booklub.entities.Users;
import com.finalProject.booklub.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UsersService {

    private static UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository)  {
            this.usersRepository = usersRepository;
        }

    public List<Users> getUsers() {
        return usersRepository.findAll();
    }
    public static void addNewUser(Users users) {
        Optional<Users> usersByOptional = usersRepository.findUsersByFullName(users.getFullName());
        if(usersByOptional.isPresent()){
            throw new IllegalStateException("book already insert");
        }
        usersRepository.save(users);
        }

    public void deleteUser(Users user) {
        usersRepository.findUsersByFullName(user.getFullName());
        boolean exists = usersRepository.existsById(user.getUsersId());
        if(!exists){
            throw new IllegalStateException("The book does not exist");
        }
        usersRepository.deleteById(user.getUsersId());
        }

    @Transactional
    public void updateUser(long usersId, String FullName, String phoneNumber, String email){
        Users users = usersRepository.findById(usersId).orElseThrow(() -> new IllegalStateException("the book is not exist"));

        if (FullName != null && FullName.length() > 0 && !Objects.equals(users.getFullName(), FullName)){
            users.setFullName(FullName);
        }
        if (phoneNumber != null && phoneNumber.length()> 0 && !Objects.equals(users.getPhoneNumber(), phoneNumber)){
            users.setPhoneNumber(phoneNumber);
        }
        if (phoneNumber != null && email.length()> 0 && !Objects.equals(users.getEmail(), email)){
            users.setEmail(email);
        }
    }

        public Optional<Users> searchUser (Specification<Users> bookSpec) {
            return usersRepository.findOne(bookSpec);
        }

}

