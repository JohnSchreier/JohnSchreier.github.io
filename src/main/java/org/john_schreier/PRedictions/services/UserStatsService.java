package org.john_schreier.PRedictions.services;

import org.john_schreier.PRedictions.exceptions.PRException;
import org.john_schreier.PRedictions.model.UserStats;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserStatsService {

    public List<UserStats> getAllUserStats() throws PRException;

    public UserStats saveUserStats(UserStats userStats) throws PRException;

    public UserStats findUserStatsByEmail(String email) throws PRException;

    public void deleteUserStatsByEmail(long id) throws PRException;

}
