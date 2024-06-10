package se.lexicon.g49meetingcalendarjpa.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.g49meetingcalendarjpa.entity.User;

import java.util.List;

@DataJpaTest
public class UserRepositoryTest {
    @Autowired UserRepository userRepository;

    @Test
    public void findAll() {

        //create user 1 and save to repository
        User user1 = new User();
        user1.setUsername("Test UserName 1");
        user1.setEmail("TestEmail");
        user1.setPassword("plainTextPassword"); // This will be hashed
        user1.setEnabled(true);
        userRepository.save(user1);

        //create user 2 and save to repository
        User user2 = new User();
        user2.setUsername("Test UserName 2");
        user2.setEmail("TestEmail2");
        user2.setPassword("plainTextPassword2");
        user2.setEnabled(true);
        userRepository.save(user2);

        // Retrieve all users
        List<User> users = userRepository.findAll();

        // Assertions
        Assertions.assertEquals(2, users.size(), "There should be 2 users in the repository");

        // Verify the properties of the users
        User retrievedUser1 = users.get(0);
        Assertions.assertEquals("Test UserName 1", retrievedUser1.getUsername());
        Assertions.assertEquals("TestEmail", retrievedUser1.getEmail());
        Assertions.assertEquals("plainTextPassword", retrievedUser1.getPassword()); // Assuming no hashing yet
        Assertions.assertTrue(retrievedUser1.isEnabled());

        User retrievedUser2 = users.get(1);
        Assertions.assertEquals("Test UserName 2", retrievedUser2.getUsername());
        Assertions.assertEquals("TestEmail2", retrievedUser2.getEmail());
        Assertions.assertEquals("plainTextPassword2", retrievedUser2.getPassword()); // Assuming no hashing yet
        Assertions.assertTrue(retrievedUser2.isEnabled());
    }
    }

