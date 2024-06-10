package se.lexicon.g49meetingcalendarjpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.g49meetingcalendarjpa.entity.Calendar;

import java.util.List;

@DataJpaTest
public class CalendarRepositoryTest {

    @Autowired private CalendarRepository calendarRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private MeetingRepository meetingRepository;



}
