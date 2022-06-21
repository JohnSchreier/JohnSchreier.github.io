package com.example.Schreier_John_PRedictions_CaseStudy.services.impl;

import com.example.Schreier_John_PRedictions_CaseStudy.exceptions.PRException;
import com.example.Schreier_John_PRedictions_CaseStudy.model.User;
import com.example.Schreier_John_PRedictions_CaseStudy.model.UserStats;
import com.example.Schreier_John_PRedictions_CaseStudy.repository.UserStatsRepository;
import com.example.Schreier_John_PRedictions_CaseStudy.services.UserStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserStatsServiceImpl implements UserStatsService {
    @Autowired
    UserStatsRepository userStatsRepository;

    public UserStatsServiceImpl(UserStatsRepository userStatsRepository) {
        super();
        this.userStatsRepository = userStatsRepository;
    }
    @Override
    public List<UserStats> getAllUserStats(){
        return userStatsRepository.findAll();
    }

    @Override
    public UserStats saveUserStats(UserStats userStats) throws PRException {
        if (userStats == null){
            throw new PRException("No UserStats Saved.");
        }
        return userStatsRepository.save(userStats);
    }

    @Override
    public UserStats findUserStatsByEmail(String email) throws PRException{
        if (email ==null){
            throw new PRException("No user stats found with that email");
        }
        return userStatsRepository.findByEmail(email);
    }

    @Override
    public void deleteUserStatsByEmail(long id) {
        userStatsRepository.deleteById(id);
    }

    public void updateUserStats(UserStats userStats) {
        userStatsRepository.save(userStats);
    }

}

