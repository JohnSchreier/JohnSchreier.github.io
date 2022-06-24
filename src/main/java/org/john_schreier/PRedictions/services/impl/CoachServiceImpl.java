package org.john_schreier.PRedictions.services.impl;

import org.john_schreier.PRedictions.model.Coach;
import org.john_schreier.PRedictions.repository.CoachRepository;
import org.john_schreier.PRedictions.services.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoachServiceImpl implements CoachService {
//    Implementation for connecting Coach repo to the controllers
//    Methods mostly created for future admin implementation
    @Autowired
    CoachRepository coachRepository;

    public CoachServiceImpl(CoachRepository coachRepository) {
        super();
        this.coachRepository = coachRepository;
    }

    @Override
    public Coach findCoachById(long id) {
        return coachRepository.findById(id);
    }
}
