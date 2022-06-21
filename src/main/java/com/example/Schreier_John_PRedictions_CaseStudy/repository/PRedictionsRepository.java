package com.example.Schreier_John_PRedictions_CaseStudy.repository;

import com.example.Schreier_John_PRedictions_CaseStudy.model.PRedictions;
import com.example.Schreier_John_PRedictions_CaseStudy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PRedictionsRepository extends JpaRepository<PRedictions, String> {
    @Query(value = "SELECT p FROM PRedictions p WHERE p.user.email=?1")
    PRedictions findByUserEmail(String email);

}
