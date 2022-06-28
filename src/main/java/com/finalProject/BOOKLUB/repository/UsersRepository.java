package com.finalProject.booklub.repository;

import com.finalProject.booklub.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository <Users, Long>, PagingAndSortingRepository <Users, Long>, JpaSpecificationExecutor <Users> {

    Optional<Users> findUsersByFullName(String fullName);

}
