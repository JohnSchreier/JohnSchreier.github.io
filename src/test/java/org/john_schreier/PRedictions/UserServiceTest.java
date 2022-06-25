package org.john_schreier.PRedictions;

import org.john_schreier.PRedictions.model.User;
import org.john_schreier.PRedictions.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserServiceTest {
    //    Tests method in the UserServiceRepository which gets a user by their email address. "m@email.com" is used as it is already in the db.
    @Autowired
    UserService userService;

    @Test
    public void testGetUserByEmail() {
        User user = userService.getUserByEmail("m@email.com");
        System.out.println(user.getFirstName());
        assertThat(user).isNotNull();

    }
}
