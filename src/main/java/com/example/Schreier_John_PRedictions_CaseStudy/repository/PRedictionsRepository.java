package com.example.Schreier_John_PRedictions_CaseStudy.repository;

import com.example.Schreier_John_PRedictions_CaseStudy.model.PRedictions;
import com.example.Schreier_John_PRedictions_CaseStudy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PRedictionsRepository extends JpaRepository<PRedictions, String> {
    @Query(value = "SELECT p FROM PRedictions p WHERE p.user.email=?1")
    PRedictions findByUserEmail(String email);

    @Modifying
    @Transactional
    @Query(value = "UPDATE PRedictions pr SET pr.marathonPrediction =:marathonPrediction WHERE pr.user.email=:email")
    void updateMarPredictionByEmail(@Param("marathonPrediction") String marathonPrediction, @Param("email") String email);
//    @Query(value = "UPDATE PRedictions SET pr.mara ='Your Mar prediction is 6:00' WHERE  `prediction_id`=1")

    PRedictions findPredictionsByUser(User user);

//    @Modifying
//    @Transactional
//    @Query(value = "UPDATE PRedictions pr SET pr.halfMarathonPrediction =:hmPredic WHERE pr.user.email=:email")
//    PRedictions updateHMPredictionByEmail(@Param("hmPredic") String halfMarathonPrediction, @Param("email") String email);

}
