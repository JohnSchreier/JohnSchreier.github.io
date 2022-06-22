package com.example.Schreier_John_PRedictions_CaseStudy;
import com.example.Schreier_John_PRedictions_CaseStudy.model.PRedictions;
import com.example.Schreier_John_PRedictions_CaseStudy.model.User;
import com.example.Schreier_John_PRedictions_CaseStudy.repository.PRedictionsRepository;
import com.example.Schreier_John_PRedictions_CaseStudy.repository.UserRepository;
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
public class PRedictionsRepositoryTest {

    @Autowired
    private PRedictionsRepository predictionsRepository;
    @Autowired
    private UserRepository userRepository;
    @Test
    public void testFindPredictionsByUser() {
    User user = userRepository.findUserByEmail("test@email.com");
    PRedictions predictions = predictionsRepository.findPredictionsByUser(user);
        System.out.println("This worked?");
        System.out.println(predictions);
        assertThat(predictions).isNotNull();
}
}
