package org.john_schreier.PRedictions.repository;

import org.john_schreier.PRedictions.model.UserStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStatsRepository extends JpaRepository<UserStats, Long>{
    @Query("SELECT u FROM UserStats u WHERE u.user.email=?1")
    UserStats findByEmail(String email);


}
