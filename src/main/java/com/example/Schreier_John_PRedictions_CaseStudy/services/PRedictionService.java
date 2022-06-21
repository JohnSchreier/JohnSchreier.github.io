package com.example.Schreier_John_PRedictions_CaseStudy.services;

import com.example.Schreier_John_PRedictions_CaseStudy.exceptions.PRException;
import com.example.Schreier_John_PRedictions_CaseStudy.model.PRedictions;
import com.example.Schreier_John_PRedictions_CaseStudy.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PRedictionService {
    PRedictions findPredictionsByEmail(String email) throws PRException;
    List<PRedictions> getAllPredictions();
    PRedictions savePrediction(PRedictions predictions) throws PRException;


}
