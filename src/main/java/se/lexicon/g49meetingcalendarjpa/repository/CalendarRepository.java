package se.lexicon.g49meetingcalendarjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.g49meetingcalendarjpa.entity.Calendar;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Integer> {
}
