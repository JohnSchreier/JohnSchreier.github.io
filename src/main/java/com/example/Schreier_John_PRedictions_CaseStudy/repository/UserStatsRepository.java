package com.example.Schreier_John_PRedictions_CaseStudy.repository;

import com.example.Schreier_John_PRedictions_CaseStudy.model.UserStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStatsRepository extends JpaRepository<UserStats, String>{
    UserStats findByEmail(String email);
}
