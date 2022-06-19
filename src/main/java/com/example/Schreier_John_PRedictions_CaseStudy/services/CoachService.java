package com.example.Schreier_John_PRedictions_CaseStudy.services;

import com.example.Schreier_John_PRedictions_CaseStudy.model.UserStats;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface CoachService extends UserDetailsService {
    UserStats saveCoachGoalsHistory(UserStats userStats);
}
