package org.john_schreier.PRedictions.repository;

import org.john_schreier.PRedictions.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {
//    This repo exists for future admin implementation, should the project be scaled up to add new coaches.
    @Query(value = "SELECT c FROM Coach c WHERE c.id=?1")
    Coach findById(long id);
}
