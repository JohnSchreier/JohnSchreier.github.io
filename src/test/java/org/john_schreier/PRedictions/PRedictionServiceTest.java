package org.john_schreier.PRedictions;

import org.john_schreier.PRedictions.exceptions.PRException;
import org.john_schreier.PRedictions.model.PRedictions;
import org.john_schreier.PRedictions.services.PRedictionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class PRedictionServiceTest {

    @Qualifier("PRedictionServiceImpl")
    @Autowired
    private PRedictionService predictionService;

    @Test
    public void testFindPredictionsByEmail() throws PRException {
        PRedictions prediction = predictionService.findPredictionsByEmail("test@email.com");
        System.out.println(prediction.getMarathonPrediction());
        assertThat(prediction).isNotNull();
    }
}
