package org.john_schreier.PRedictions.repository;

import org.john_schreier.PRedictions.model.PRedictions;
import org.john_schreier.PRedictions.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PRedictionsRepository extends JpaRepository<PRedictions, String> {
    //      This repo connects to the PRedictions table in the db.
    //      Methods for calling User PRedictions by email or User,
    //      seeing if they exist, updating both half-marathon and
    //      marathon PRedictions in the db, and deleting PRedictions.
    @Query(value = "SELECT p FROM PRedictions p WHERE p.user.email=?1")
    PRedictions findPredictionsByEmail(String email);

    PRedictions findPredictionsByUser(User user);
    boolean existsPRedictionsByUser(User user);

    @Modifying
    @Transactional
    @Query(value = "UPDATE PRedictions pr SET pr.halfMarathonPrediction =:halfMarathonPrediction WHERE pr.user.email=:email")
    int updateHalfMarPredictionByEmail(@Param("halfMarathonPrediction") String halfMarathonPrediction, @Param("email") String email);

    @Modifying
    @Transactional
    @Query(value = "UPDATE PRedictions pr SET pr.marathonPrediction =:marathonPrediction WHERE pr.user.email=:email")
    int updateMarPredictionByEmail(@Param("marathonPrediction") String marathonPrediction, @Param("email") String email);

    @Transactional
    int deletePRedictionsByUser(User user);

}
