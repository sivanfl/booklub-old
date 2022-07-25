package com.finalProject.booklub.logInUsers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class logInUsersService {

    private static logInUsersRepository logInUsersRepository;

    @Autowired
    public logInUsersService(logInUsersRepository usersRepository)  {
            this.logInUsersRepository = usersRepository;
        }

    public List<logInUsers> getUsers() {
        return logInUsersRepository.findAll();
    }
    public static void addNewUser(logInUsers users) {
        Optional<logInUsers> usersByOptional = logInUsersRepository.findUsersByUsername(users.getUsername());
        if(usersByOptional.isPresent()){
            throw new IllegalStateException("book already insert");
        }
        logInUsersRepository.save(users);
        }

//    public void deleteUser(logInUsers logInUsers) {
//        logInUsersRepository.findUsersByFullName(logInUsers.getUsername());
//        boolean exists = logInUsersRepository.existsById(logInUsers.getId());
//        if(!exists){
//            throw new IllegalStateException("The book does not exist");
//        }
//        logInUsersRepository.deleteById(logInUsers.getId());
//        }

//    @Transactional
//    public void updateUser(long id, String username, String password, Calendar cal, boolean isValid, boolean isExpired){
//        logInUsers logInusers = logInUsersRepository.findById(id).orElseThrow(() -> new IllegalStateException("the book is not exist"));
//
//        if (username != null && username.length() > 0 && !Objects.equals(logInusers.getUsername(), username)){
//            logInusers.setUsername(username);
//        }
//        if (password != null && password.length()> 0 && !Objects.equals(logInusers.getPassword(), password)){
//            logInusers.setPassword(password);
//        }
//        if (date <  && !Objects.equals(logInusers.isValid(), isValid)){
//            logInusers.setEmail(email);
//        }
//    }

//        public Optional<logInUsers> searchUser (Specification<logInUsers> bookSpec) {
//            return logInUsersRepository.findOne(bookSpec);
//        }

}

