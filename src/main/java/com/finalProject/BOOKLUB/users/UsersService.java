package com.finalProject.booklub.users;

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
            throw new IllegalStateException("user already insert");
        }
        usersRepository.save(users);
        }

    public void deleteUser(Users user) {
        usersRepository.findUsersByFullName(user.getFullName());
        boolean exists = usersRepository.existsById(user.getId());
        if(!exists){
            throw new IllegalStateException("The book does not exist");
        }
        usersRepository.deleteById(user.getId());
        }

    @Transactional
    public void updateUser(long id, String fullName, String phoneNumber, String email,String city,
                           String street, String readingCategory,String username, String password){

        Users users = usersRepository.findById(id).orElseThrow(() -> new IllegalStateException("the user is not registered"));

        if (fullName != null && fullName.length() > 0 && !Objects.equals(users.getFullName(), fullName)){
            users.setFullName(fullName);
        }
        if (phoneNumber != null && phoneNumber.length()> 0 && !Objects.equals(users.getPhoneNumber(), phoneNumber)){
            users.setPhoneNumber(phoneNumber);
        }
        if (email != null && email.length()> 0 && !Objects.equals(users.getEmail(), email)){
            users.setEmail(email);
        }
        if (city != null && city.length() > 0 && !Objects.equals(users.getCity(), city)){
            users.setCity(city);
        }
        if (street != null && street.length()> 0 && !Objects.equals(users.getStreet(), street)){
            users.setStreet(street);
        }
        if (readingCategory != null && readingCategory.length()> 0 && !Objects.equals(users.getReadingCategory(), readingCategory)){
            users.setReadingCategory(readingCategory);
        }
        if (username != null && username.length()> 0 && !Objects.equals(users.getUsername(), username)){
            users.setUsername(username);
        }
        if (password != null && password.length()> 0 && !Objects.equals(users.getPassword(), password)){
            users.setPassword(password);
        }
    }

        public Optional<Users> searchUser (Specification<Users> usersSpec) {
            return usersRepository.findOne(usersSpec);
        }

}

