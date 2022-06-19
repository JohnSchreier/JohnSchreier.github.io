package com.example.Schreier_John_PRedictions_CaseStudy.services.impl;

import com.example.Schreier_John_PRedictions_CaseStudy.model.UserStats;
import com.example.Schreier_John_PRedictions_CaseStudy.services.CoachService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CoachServiceImpl implements CoachService {
    @Override
    public UserStats saveCoachGoalsHistory(UserStats userStats) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
