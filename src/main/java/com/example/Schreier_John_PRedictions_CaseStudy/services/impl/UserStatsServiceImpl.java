package com.example.Schreier_John_PRedictions_CaseStudy.services.impl;

import com.example.Schreier_John_PRedictions_CaseStudy.model.UserStats;
import com.example.Schreier_John_PRedictions_CaseStudy.repository.UserStatsRepository;
import com.example.Schreier_John_PRedictions_CaseStudy.services.UserStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserStatsServiceImpl implements UserStatsService {
    @Autowired
    UserStatsRepository userStatsRepository;

    public UserStats findUserStatsByEmail(String email){
        return userStatsRepository.findByEmail(email);
    }

    @Override
    public void addUserStats(UserStats userStats) {
        userStatsRepository.save(userStats);
    }
}

