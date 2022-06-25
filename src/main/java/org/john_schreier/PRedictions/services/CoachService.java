package org.john_schreier.PRedictions.services;

import org.john_schreier.PRedictions.exceptions.PRException;
import org.john_schreier.PRedictions.model.Coach;
import org.springframework.stereotype.Service;

@Service
public interface CoachService {

    public Coach findCoachById(long id) throws PRException;
}
