package org.john_schreier.PRedictions;
import org.john_schreier.PRedictions.model.User;
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
public class UserRepositoryTest {
//    Tests method in the UserRepository which finds a user by their email address. "test@email.com" is used as it is already in the db.
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindUserByEmail(){
        User user = userRepository.findUserByEmail("test@email.com");
        assertThat(user).isNotNull();
        System.out.println("~~~~~~~~findUserByEmail working~~~~~~~~~");
        System.out.println(user.getFirstName());
    }
}
