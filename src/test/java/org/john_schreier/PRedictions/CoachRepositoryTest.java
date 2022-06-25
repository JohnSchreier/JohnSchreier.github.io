package org.john_schreier.PRedictions;

import org.john_schreier.PRedictions.model.Coach;
import org.john_schreier.PRedictions.repository.CoachRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CoachRepositoryTest {
//    This class tests the findById method in the coach repo, which should return a coach based on their ID number
//    Not being used in the current version of this app. Included for future implementation and scaling up, should admin
//    functions be added.
    @Autowired
    private CoachRepository coachRepository;

    @Test
    public void testFindById() {
        Coach coach = coachRepository.findById(1);
        System.out.println(coach.getCoachFirstName());
        assertThat(coach).isNotNull();
    }
}
