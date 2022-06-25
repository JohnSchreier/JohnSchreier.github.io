package org.john_schreier.PRedictions.services;

import org.john_schreier.PRedictions.exceptions.PRException;
import org.john_schreier.PRedictions.model.PRedictions;
import org.john_schreier.PRedictions.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PRedictionService {
    PRedictions findPredictionsByEmail(String email) throws PRException;

    List<PRedictions> getAllPredictions();

    PRedictions savePrediction(PRedictions predictions) throws PRException;

    int savePredictionMarExists(String halfMarathonPrediction, String email) throws PRException;

    int savePredictionHalfExists(String marathonPrediction, String email) throws PRException;

    public PRedictions getPredictionByUser(User user) throws PRException;

    boolean existsPRedictionsByUser(User user);

    int deletePRedictionsByUser(User user);
}
