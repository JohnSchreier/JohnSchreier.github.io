package com.example.Schreier_John_PRedictions_CaseStudy.services.impl;

import com.example.Schreier_John_PRedictions_CaseStudy.exceptions.PRException;
import com.example.Schreier_John_PRedictions_CaseStudy.model.PRedictions;
import com.example.Schreier_John_PRedictions_CaseStudy.model.User;
import com.example.Schreier_John_PRedictions_CaseStudy.repository.PRedictionsRepository;
import com.example.Schreier_John_PRedictions_CaseStudy.services.PRedictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PRedictionServiceImpl implements PRedictionService {
    @Autowired
    private PRedictionsRepository predicRepo;

    public PRedictionServiceImpl(PRedictionsRepository predicRepo) {
        super();
        this.predicRepo = predicRepo;
    }

    @Override
    public PRedictions findPredictionsByEmail(String email) throws PRException {
        if(email == null){
            throw new PRException("PR's not found with that email");
        }
        return predicRepo.findByUserEmail(email);
    }

    @Override
    public List<PRedictions> getAllPredictions() {
        return predicRepo.findAll();
    }

    @Override
    public PRedictions savePrediction(PRedictions predictions) throws PRException {
        if (predictions == null) {
            throw new PRException("No PRedictions found");
        }
        return predicRepo.save(predictions);
    }
    public PRedictions savePredictionHalfExists(String marathonPrediction, String email) throws PRException {
        return predicRepo.updateMarPredictionByEmail(marathonPrediction, email);
    }
    public PRedictions getPredictionByUser(User user) throws PRException {
        if (user == null) {
            throw new PRException("No user found");
        }
        return predicRepo.findPredictionsByUser(user);
    }
}
