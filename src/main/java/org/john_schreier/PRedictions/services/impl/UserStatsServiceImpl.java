package org.john_schreier.PRedictions.services.impl;

import org.john_schreier.PRedictions.constants.ExceptionConstants;
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

    //  Method for users to save their coach choice, goals, and history.
    @Override
    public UserStats saveUserStats(UserStats userStats) throws PRException {
        if (userStats == null) {
            throw new PRException(ExceptionConstants.NO_USER_STATS_SAVED);
        }
        return userStatsRepository.save(userStats);
    }

    @Override
    public UserStats findUserStatsByEmail(String email) throws PRException {
        if (email == null) {
            throw new PRException(ExceptionConstants.NO_USER_STATS_FOUND_WITH_THAT_EMAIL);
        }
        return userStatsRepository.findByEmail(email);
    }

    //  This method was added for future implementation, should a user want to delete their old goals and set new ones.
    @Override
    public void deleteUserStatsByEmail(long id) throws PRException {
        if (id == 0) {
            throw new PRException(ExceptionConstants.NO_USER_STATS_FOUND_TO_DELETE);
        }
        userStatsRepository.deleteById(id);
    }

    //    This method was added for future implementation, should a user want to update their UserStats.
    public void updateUserStats(UserStats userStats) throws PRException {
        if (userStats == null) {
            throw new PRException(ExceptionConstants.NO_USER_STATS_FOUND_FOR_UPDATE);
        }
        userStatsRepository.save(userStats);
    }

}

