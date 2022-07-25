package com.finalProject.booklub.logInUsers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface logInUsersRepository extends JpaRepository <logInUsers, Long>, PagingAndSortingRepository <logInUsers, Long>, JpaSpecificationExecutor <logInUsers> {

    Optional<logInUsers> findUsersByUsername(String username);

}
