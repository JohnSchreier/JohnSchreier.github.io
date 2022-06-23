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
    @Query(value = "SELECT p FROM PRedictions p WHERE p.user.email=?1")
    PRedictions findPredictionsByEmail(String email);

    boolean existsPRedictionsByUser(User user);

    @Modifying
    @Transactional
    @Query(value = "UPDATE PRedictions pr SET pr.halfMarathonPrediction =:halfMarathonPrediction WHERE pr.user.email=:email")
    int updateHalfMarPredictionByEmail(@Param("halfMarathonPrediction") String halfMarathonPrediction, @Param("email") String email);

    @Modifying
    @Transactional
    @Query(value = "UPDATE PRedictions pr SET pr.marathonPrediction =:marathonPrediction WHERE pr.user.email=:email")
    int updateMarPredictionByEmail(@Param("marathonPrediction") String marathonPrediction, @Param("email") String email);
//    @Modifying
    @Transactional
    int deletePRedictionsByUser(User user);

    PRedictions findPredictionsByUser(User user);


}
