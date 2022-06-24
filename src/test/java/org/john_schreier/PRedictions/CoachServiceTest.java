package org.john_schreier.PRedictions;

import org.john_schreier.PRedictions.model.Coach;
import org.john_schreier.PRedictions.repository.CoachRepository;
import org.john_schreier.PRedictions.services.CoachService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
@AutoConfigureTestDatabase(replace= Replace.NONE)
@Rollback(false)
public class CoachServiceTest {
    @Autowired
    private CoachService coachService;
    @Autowired
    private CoachRepository coachRepository;
    @Test
    public void testFindCoachById(){

        Coach coach = coachService.findCoachById(2);
        System.out.println("coach = " + coach.getCoachLastName());
        assertThat(coach).isNotNull();
    }
}
