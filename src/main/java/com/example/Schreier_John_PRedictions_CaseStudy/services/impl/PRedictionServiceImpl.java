package com.example.Schreier_John_PRedictions_CaseStudy.services.impl;

import com.example.Schreier_John_PRedictions_CaseStudy.exceptions.PRException;
import com.example.Schreier_John_PRedictions_CaseStudy.model.PRedictions;
import com.example.Schreier_John_PRedictions_CaseStudy.model.User;
import com.example.Schreier_John_PRedictions_CaseStudy.repository.PRedictionsRepository;
import com.example.Schreier_John_PRedictions_CaseStudy.services.PRedictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
public class PRedictionServiceImpl implements PRedictionService {

    @Autowired
    private PRedictionsRepository predicRepo;

    public PRedictionServiceImpl(PRedictionsRepository predicRepo) {
        this.predicRepo = predicRepo;
    }

    @Override
    public String getPredictionByUser(User user) throws PRException {
        PRedictions predic = predicRepo.findByUser(user);
        System.out.println("Half Marathon Prediction: " + predic);
        if(predic == null){
            throw new PRException("PR not found");
        }
        return predic.getHalfMarathonPrediction();
    }

    @Override
    public List<PRedictions> getAllPredictions() {
        return predicRepo.findAll();
    }

    @Override
    public PRedictions savePrediction(PRedictions predictions) {
        return predicRepo.save(predictions);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
