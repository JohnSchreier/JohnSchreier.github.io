package com.example.Schreier_John_PRedictions_CaseStudy.services;

import com.example.Schreier_John_PRedictions_CaseStudy.model.User;
import com.example.Schreier_John_PRedictions_CaseStudy.model.UserStats;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserStatsService {

    public List<UserStats> getAllUserStats();
    public UserStats saveUserStats(UserStats userStats);
    public UserStats findUserStatsByEmail(String email);
    public void deleteUserStatsByEmail(long id);

}
