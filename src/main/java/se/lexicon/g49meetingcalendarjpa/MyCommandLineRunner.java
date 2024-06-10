package se.lexicon.g49meetingcalendarjpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.g49meetingcalendarjpa.entity.User;
import se.lexicon.g49meetingcalendarjpa.repository.UserRepository;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        User user = new User();
        user.setUsername("TestUserName");
        user.setEmail("TestEmail");
        user.setPassword("plainTextPassword"); // This will be hashed
        user.setEnabled(true);
        userRepository.save(user);

    }
}
