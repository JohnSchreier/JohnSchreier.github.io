package com.example.Schreier_John_PRedictions_CaseStudy.services.impl;

import com.example.Schreier_John_PRedictions_CaseStudy.model.Coach;
import com.example.Schreier_John_PRedictions_CaseStudy.repository.CoachRepository;
import com.example.Schreier_John_PRedictions_CaseStudy.services.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoachServiceImpl implements CoachService {
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
