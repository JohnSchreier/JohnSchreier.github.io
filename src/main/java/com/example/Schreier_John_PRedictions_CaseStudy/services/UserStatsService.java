package com.example.Schreier_John_PRedictions_CaseStudy.services;

import com.example.Schreier_John_PRedictions_CaseStudy.model.UserStats;
import org.springframework.stereotype.Service;

@Service
public interface UserStatsService {
    public UserStats findUserStatsByEmail(String email);
    public void addUserStats(UserStats userStats);
}
