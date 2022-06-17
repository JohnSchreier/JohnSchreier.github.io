package com.example.Schreier_John_PRedictions_CaseStudy.repository;
import com.example.Schreier_John_PRedictions_CaseStudy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, String> {
    //<User> type, String type for our primary key^
@Query("SELECT u FROM User u WHERE u.email= :email")
    public User findUserByEmail(String email);

//    public User saveUser(User user);
}