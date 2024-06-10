package se.lexicon.g49meetingcalendarjpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.g49meetingcalendarjpa.entity.Calendar;
import se.lexicon.g49meetingcalendarjpa.entity.Meeting;
import se.lexicon.g49meetingcalendarjpa.entity.User;
import se.lexicon.g49meetingcalendarjpa.repository.CalendarRepository;
import se.lexicon.g49meetingcalendarjpa.repository.MeetingRepository;
import se.lexicon.g49meetingcalendarjpa.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MeetingRepository meetingRepository;

    @Autowired
    CalendarRepository calendarRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {


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

        //Create and save a calendar
        Calendar calendar1 = new Calendar();
        calendar1.setTitle("Calendar Title 1");
        calendar1.setUserName(user1.getUsername());
        calendar1.setUserName(user2.getUsername());
        calendarRepository.save(calendar1);

        // Create and save a second calendar
        Calendar calendar2 = new Calendar();
        calendar2.setTitle("Calendar Title 2");
        calendar2.setUserName(user2.getUsername());
        calendarRepository.save(calendar2);


        //create a meeting
        Meeting meeting = new Meeting();
        meeting.setTitle("Meeting Title");
        meeting.setDescription("Meeting Description");
        meeting.setStartTime(LocalDateTime.of(2024, 6, 15, 10, 0));
        meeting.setEndTime(LocalDateTime.of(2024, 6, 15, 11, 0));

        // Set participants for the meeting
        meeting.addParticipant(user1);
        meeting.addParticipant(user2);

        // Set calendars for the meeting
        List<Calendar> calendars = new ArrayList<>();
        calendars.add(calendar1);
        calendars.add(calendar2);
        meeting.setCalendars(calendars);

        // Save the meeting
        meetingRepository.save(meeting);

    }
}
