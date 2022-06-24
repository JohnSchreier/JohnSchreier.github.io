package org.john_schreier.PRedictions.services.impl;

import org.john_schreier.PRedictions.exceptions.PRException;
import org.john_schreier.PRedictions.model.UserStats;
import org.john_schreier.PRedictions.repository.UserStatsRepository;
import org.john_schreier.PRedictions.services.UserStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserStatsServiceImpl implements UserStatsService {
//    Implementation of the UserStats service which defines the logic for finding
//    a user's goals and history. Methods for updating and deleting goals/history have
//    been defined for future implementation. 
    @Autowired
    UserStatsRepository userStatsRepository;

    public UserStatsServiceImpl(UserStatsRepository userStatsRepository) {
        super();
        this.userStatsRepository = userStatsRepository;
    }

    @Override
    public List<UserStats> getAllUserStats() {
        return userStatsRepository.findAll();
    }

    @Override
    public UserStats saveUserStats(UserStats userStats) throws PRException {
        if (userStats == null) {
            throw new PRException("No UserStats Saved.");
        }
        return userStatsRepository.save(userStats);
    }

    @Override
    public UserStats findUserStatsByEmail(String email) throws PRException {
        if (email == null) {
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

