package org.john_schreier.PRedictions.services.impl;

import org.john_schreier.PRedictions.exceptions.PRException;
import org.john_schreier.PRedictions.model.PRedictions;
import org.john_schreier.PRedictions.model.User;
import org.john_schreier.PRedictions.repository.PRedictionsRepository;
import org.john_schreier.PRedictions.services.PRedictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PRedictionServiceImpl implements PRedictionService {
    //    Implementation of PRedictionService which defines the logic of each PRedictionService method.
//    Bridge between the PRedictionService Repo and the calling of CRUD on the view/controllers.
    @Autowired
    private PRedictionsRepository predicRepo;

    public PRedictionServiceImpl(PRedictionsRepository predicRepo) {
        super();
        this.predicRepo = predicRepo;
    }

    @Override
    public PRedictions findPredictionsByEmail(String email) throws PRException {
        if (email == null) {
            throw new PRException("PR's not found with that email");
        }
        return predicRepo.findPredictionsByEmail(email);
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

    public int savePredictionMarExists(String halfMarathonPrediction, String email) throws PRException {
        if (email == null) {
            throw new PRException("savePredictionMarExists error. email does not exist");
        }
        return predicRepo.updateHalfMarPredictionByEmail(halfMarathonPrediction, email);
    }

    public int savePredictionHalfExists(String marathonPrediction, String email) throws PRException {
        if (email == null) {
            throw new PRException("savePredictionHalfExists error. email does not exist");
        }
        return predicRepo.updateMarPredictionByEmail(marathonPrediction, email);
    }

    public PRedictions getPredictionByUser(User user) throws PRException {
        if (user == null) {
            throw new PRException("No user found");
        }
        return predicRepo.findPredictionsByUser(user);
    }

    public boolean existsPRedictionsByUser(User user) throws PRException {
        if (user == null) {
            throw new PRException("User may not exist");
        }
        return predicRepo.existsPRedictionsByUser(user);
    }

    public int deletePRedictionsByUser(User user) throws PRException {
        if (user == null) {
            throw new PRException("No user found for deletion");
        }
        return predicRepo.deletePRedictionsByUser(user);
    }
}
