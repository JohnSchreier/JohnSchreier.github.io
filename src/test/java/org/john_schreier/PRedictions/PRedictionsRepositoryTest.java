package org.john_schreier.PRedictions;
import org.john_schreier.PRedictions.model.PRedictions;
import org.john_schreier.PRedictions.model.User;
import org.john_schreier.PRedictions.repository.PRedictionsRepository;
import org.john_schreier.PRedictions.repository.UserRepository;
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
    @Test
    public void testExistsPRedictionsByEmail(){
        boolean trueOrFalse = predictionsRepository.existsPRedictionsByUser(userRepository.findUserByEmail("test@email.com"));
        System.out.println("boolean working?");
        assertThat(trueOrFalse).isTrue();
    }
    @Test
    public void testUpdateHalfMarPredictionByEmail() {
        int i = predictionsRepository.updateHalfMarPredictionByEmail("ur hm = 2:00", "bob@email.com");
        System.out.println("did this work?");
        PRedictions prediction = predictionsRepository.findPredictionsByUser(userRepository.findUserByEmail("bob@email.com"));
        System.out.println(prediction);
        System.out.println(i);
        assertThat(prediction).isNotNull();
    }
    @Test
    public void testUpdateMarPredictionByEmail(){
        int i = predictionsRepository.updateMarPredictionByEmail("ur mar = 2:00", "bob@email.com");
        System.out.println("did this work?");
        PRedictions prediction = predictionsRepository.findPredictionsByUser(userRepository.findUserByEmail("bob@email.com"));
        System.out.println(prediction);
        System.out.println(i);
        assertThat(prediction).isNotNull();

    }

    @Test
    public void testDeletePRedictionsByUser(){
        int i = predictionsRepository.deletePRedictionsByUser(userRepository.findUserByEmail("test@email.com"));
        System.out.println("PRedictions should all be deleted!");
        PRedictions prediction = predictionsRepository.findPredictionsByUser(userRepository.findUserByEmail("test@email.com"));
        assertThat(prediction).isNull();
    }
}
