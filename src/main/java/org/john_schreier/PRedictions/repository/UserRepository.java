package org.john_schreier.PRedictions.repository;

import org.john_schreier.PRedictions.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, String> {
    //    This repo finds a User by their email address.
    @Query("SELECT u FROM User u WHERE u.email= :email")
    public User findUserByEmail(@Param("email") String email);

}