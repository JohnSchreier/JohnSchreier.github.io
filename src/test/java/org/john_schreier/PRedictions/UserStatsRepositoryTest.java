package org.john_schreier.PRedictions;

import org.john_schreier.PRedictions.model.UserStats;
import org.john_schreier.PRedictions.repository.UserStatsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class UserStatsRepositoryTest {
    @Autowired
    private UserStatsRepository userStatsRepository;

    @Test
    public void testFindByEmail(){
        UserStats userStats = userStatsRepository.findByEmail("test@email.com");
        System.out.println(userStats.getUser().getFirstName());
        assertThat(userStats).isNotNull();
    }


}
