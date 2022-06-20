package com.example.Schreier_John_PRedictions_CaseStudy.services;

import com.example.Schreier_John_PRedictions_CaseStudy.model.Coach;
import org.springframework.stereotype.Service;

@Service
public interface CoachService {

    public Coach findCoachById(long id);
}
